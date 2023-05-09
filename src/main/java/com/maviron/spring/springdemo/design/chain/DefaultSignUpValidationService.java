package com.maviron.spring.springdemo.design.chain;

import com.maviron.spring.springdemo.dao.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

@Service
@AllArgsConstructor
public class DefaultSignUpValidationService implements SignUpValidationService {

    private final UserRepository userRepository = null;

    @Override
    public ValidationResult validate(SignUpCommand command) {
        return new CommandConstraintsValidationStep()
                .linkWith(new UsernameDuplicationValidationStep(userRepository))
                .linkWith(new EmailDuplicationValidationStep(userRepository))
                .validate(command);
    }

    private static class CommandConstraintsValidationStep extends ValidationStep<SignUpCommand> {

        @Override
        public ValidationResult validate(SignUpCommand command) {
            try (ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory()) {
                final Validator validator = validatorFactory.getValidator();
                final Set<ConstraintViolation<SignUpCommand>> constraintsViolations = validator.validate(command);

                if (!constraintsViolations.isEmpty()) {
                    return ValidationResult.invalid(constraintsViolations.iterator().next().getMessage());
                }
            }
            return checkNext(command);
        }
    }

    @AllArgsConstructor
    private static class UsernameDuplicationValidationStep extends ValidationStep<SignUpCommand> {

        private final UserRepository userRepository;

        @Override
        public ValidationResult validate(SignUpCommand command) {
            if (userRepository.findByUsername(command.getUsername()) != null) {
                return ValidationResult.invalid(String.format("Username [%s] is already taken", command.getUsername()));
            }
            return checkNext(command);
        }
    }

    @AllArgsConstructor
    private static class EmailDuplicationValidationStep extends ValidationStep<SignUpCommand> {

        private final UserRepository userRepository;

        @Override
        public ValidationResult validate(SignUpCommand command) {
            if (userRepository.findByEmail(command.getEmail()) != null) {
                return ValidationResult.invalid(String.format("Email [%s] is already taken", command.getEmail()));
            }
            return checkNext(command);
        }
    }
}