package fun.sale;

import fun.sale.constants.StaticQuestions;
import fun.sale.domain.Question;
import fun.sale.handler.ResponseHandler;

import java.util.Optional;
import java.util.Scanner;

public class Game {

    public static void main(String[] args) {
        AppBeans.GAME_INSTANCE.start();
    }

    private void start() {
        try (Scanner scanner = new Scanner(System.in)) {
            Optional<Question> nextQuestion = Optional.of(StaticQuestions.FIRST_QUESTION);
            while (nextQuestion.isPresent()) {
                Question question = nextQuestion.get();
                print(question.buildFullText() + ": ");

                ResponseHandler responseHandler = question.getResponseHandler();
                String response = scanner.nextLine();

                if (responseHandler.isValid(question, response)) {
                    nextQuestion = responseHandler.getNextQuestion(question.getSeller(), response);
                } else {
                    print(String.format("Oops, you answer '%s' is invalid, let's try again. ", response));
                }
            }
        }
    }

    private static void print(String text) {
        System.out.print(text);
    }
}
