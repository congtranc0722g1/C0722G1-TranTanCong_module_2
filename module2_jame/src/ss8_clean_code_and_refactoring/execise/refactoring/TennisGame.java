package ss8_clean_code_and_refactoring.execise.refactoring;

public class TennisGame {

    public static String getScore(String player1Name, String player2Name, int playerScore1, int playerScore2) {
        String score = "";
//        int TEMP_SCORE = 0;
        final int ZERO_SCORE = 0;
        final int ONE_POINTS = 1;
        final int TWO_POINTS = 2;
        final int THREE_POINTS = 3;

        if (playerScore1 == playerScore2) {
            switch (playerScore1) {
                case ZERO_SCORE:
                    score = "Love-All";
                    break;
                case ONE_POINTS:
                    score = "Fifteen-All";
                    break;
                case TWO_POINTS:
                    score = "Thirty-All";
                    break;
                case THREE_POINTS:
                    score = "Forty-All";
                    break;
                default:
                    score = "Deuce";
                    break;
            }
        }
        return score;
    }



    private static String winner(int playerScore1, int playerScore2) {
        boolean isPlayerScore1 = playerScore1 >= 4;
        boolean isPlayerScore2 = playerScore2 >= 4;
        String score = "";
        if (isPlayerScore1 || isPlayerScore2) {

            int minusResult = playerScore1 - playerScore2;
            boolean isMinusResult1 = minusResult == 1;
            boolean isMinusResult2 = minusResult == -1;
            boolean isMinusResult3 = minusResult >= 2;

            if (isMinusResult1) score = "Advantage player1";
            else if (isMinusResult2) score = "Advantage player2";
            else if (isMinusResult3) score = "Win for player1";
            else score = "Win for player2";
        }
        return score;
    }



    private static String currentScore(int playerScore1, int playerScore2) {
        boolean isPlayerScore1 = playerScore1 >= 4;
        boolean isPlayerScore2 = playerScore2 >= 4;

        String score = "";
        int tempScore = 0;
        final int ZERO_SCORE = 0;
        final int ONE_POINTS = 1;
        final int TWO_POINTS = 2;
        final int THREE_POINTS = 3;

        if (isPlayerScore1 != isPlayerScore2) {
            for (int i = 1; i < 3; i++) {
                if (i == 1) tempScore = playerScore1;
                else {
                    score += "-";
                    tempScore = playerScore2;
                }
                switch (tempScore) {
                    case ZERO_SCORE:
                        score += "Love";
                        break;
                    case ONE_POINTS:
                        score += "Fifteen";
                        break;
                    case TWO_POINTS:
                        score += "Thirty";
                        break;
                    case THREE_POINTS:
                        score += "Forty";
                        break;
                }
            }

        }
        return score;
    }
}
