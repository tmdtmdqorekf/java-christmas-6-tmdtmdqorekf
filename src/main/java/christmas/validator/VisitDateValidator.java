package christmas.validator;

public class VisitDateValidator implements BasicValidator<String> {
    @Override
    public void validate(String input) {
        isInputEmpty(input);
        isRangeValid(input);
        isNumber(input);

    }

    public void isInputEmpty(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 입력값이 존재하지 않습니다. 다시 입력해 주세요.");
        }
    }

    public void isRangeValid(String input) {
        int number = Integer.parseInt(input);
        if (number < 1 || number > 31) {
                throw new IllegalArgumentException("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
        }
    }

    public void isNumber(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new NumberFormatException();
        }
    }
}
