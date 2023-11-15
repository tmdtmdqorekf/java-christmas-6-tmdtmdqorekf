package christmas.validator;

public class VisitDateValidator implements BasicValidator<String> {
    @Override
    public void validate(String input) {
        isInputEmpty(input);
        isRangeValid(input);

    }

    public void isInputEmpty(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException("입력값이 존재하지 않습니다. 다시 입력해 주세요.");
        }
    }

    public void isRangeValid(String input) {
        int number = Integer.parseInt(input);
        if (number < 1 || number > 31) {
                throw new IllegalArgumentException("유효하지 않은 날짜입니다. 다시 입력해 주세요.");
        }
    }
}
