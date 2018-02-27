package com.example.android.scorekeeperbball;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //declaring variables that will declare the views inside onCreate - Team A
    private TextView teamAScore;
    private TextView teamAThreePoints;
    private TextView teamATwoPoints;
    private TextView teamAOnePoint;
    private TextView teamAFouls;

    //declaring variables that will declare the views inside onCreate - Team B
    private TextView teamBScore;
    private TextView teamBThreePoints;
    private TextView teamBTwoPoints;
    private TextView teamBOnePoint;
    private TextView teamBFouls;

    //To solve the issue that the scores & stats reset to zero when rotating the cell phone
    //(portrait to landscape and vice versa)

    //Team A
    static final String stateScoreTeamA = "scoreTeamA";
    static final String stateThreePointsTeamA= "amtThreePointsTeamA";
    static final String stateTwoPointsTeamA = "amtTwoPointsTeamA";
    static final String stateOnePointTeamA = "amtOnePointTeamA";
    static final String stateFoulsTeamA = "amtFoulsTeamA";

    //Team B
    static final String stateScoreTeamB = "scoreTeamB";
    static final String stateThreePointsTeamB = "amtThreePointsTeamB";
    static final String stateTwoPointsTeamB = "amtTwoPointsTeamB";
    static final String stateOnePointTeamB = "amtOnePointTeamB";
    static final String stateFoulsTeamB = "amtFoulsTeamB";

    //Initializing variables
    int scoreTeamA = 0;
    int scoreTeamB = 0;
    int amtThreePointsTeamA = 0;
    int amtTwoPointsTeamA = 0;
    int amtOnePointTeamA = 0;
    int amtFoulsTeamA = 0;
    int amtThreePointsTeamB = 0;
    int amtTwoPointsTeamB = 0;
    int amtOnePointTeamB = 0;
    int amtFoulsTeamB = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //initializing views - Team A
        teamAScore = (TextView) findViewById(R.id.team_a_score);
        teamAThreePoints = (TextView) findViewById(R.id.team_a_three_points);
        teamATwoPoints = (TextView) findViewById(R.id.team_a_two_points);
        teamAOnePoint = (TextView) findViewById(R.id.team_a_one_point);
        teamAFouls = (TextView) findViewById(R.id.team_a_fouls);

        //initializing views - Team B
        teamBScore = (TextView) findViewById(R.id.team_b_score);
        teamBThreePoints = (TextView) findViewById(R.id.team_b_three_points);
        teamBTwoPoints = (TextView) findViewById(R.id.team_b_two_points);
        teamBOnePoint = (TextView) findViewById(R.id.team_b_one_point);
        teamBFouls = (TextView) findViewById(R.id.team_b_fouls);
    }

    //To solve the issue that the scores & stats reset to zero when rotating the cell phone
    //(portrait to landscape and vice versa)

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        // Save the teams' current score state
        savedInstanceState.putInt(stateScoreTeamA, scoreTeamA);
        savedInstanceState.putInt(stateScoreTeamB, scoreTeamB);

        //stats for Team A
        savedInstanceState.putInt(stateThreePointsTeamA, amtThreePointsTeamA);
        savedInstanceState.putInt(stateTwoPointsTeamA, amtTwoPointsTeamA);
        savedInstanceState.putInt(stateOnePointTeamA, amtOnePointTeamA);
        savedInstanceState.putInt(stateFoulsTeamA, amtFoulsTeamA);

        //stats for Team B
        savedInstanceState.putInt(stateThreePointsTeamB, amtThreePointsTeamB);
        savedInstanceState.putInt(stateTwoPointsTeamB, amtTwoPointsTeamB);
        savedInstanceState.putInt(stateOnePointTeamB, amtOnePointTeamB);
        savedInstanceState.putInt(stateFoulsTeamB, amtFoulsTeamB);

        // Always call the superclass so it can save the view hierarchy state
        super.onSaveInstanceState(savedInstanceState);
    }

    public void onRestoreInstanceState(Bundle savedInstanceState) {
        // Always call the superclass so it can restore the view hierarchy
        super.onRestoreInstanceState(savedInstanceState);

        // Restore state members from saved instance
        scoreTeamA = savedInstanceState.getInt(stateScoreTeamA);
        scoreTeamB = savedInstanceState.getInt(stateScoreTeamB);

        //stats for Team A
        amtThreePointsTeamA = savedInstanceState.getInt(stateThreePointsTeamA);
        amtTwoPointsTeamA = savedInstanceState.getInt(stateTwoPointsTeamA);
        amtOnePointTeamA = savedInstanceState.getInt(stateOnePointTeamA);
        amtFoulsTeamA = savedInstanceState.getInt(stateFoulsTeamA);

        //stats for Team B
        amtThreePointsTeamB = savedInstanceState.getInt(stateThreePointsTeamB);
        amtTwoPointsTeamB = savedInstanceState.getInt(stateTwoPointsTeamB);
        amtOnePointTeamB = savedInstanceState.getInt(stateOnePointTeamB);
        amtFoulsTeamB = savedInstanceState.getInt(stateFoulsTeamB);

        //display scores & stats for Team A
        displayForTeamA(scoreTeamA);
        displayThreePointStatsForTeamA(amtThreePointsTeamA);
        displayTwoPointStatsForTeamA(amtTwoPointsTeamA);
        displayOnePointStatsForTeamA(amtOnePointTeamA);
        displayFoulStatsForTeamA(amtFoulsTeamA);

        //display scores & stats for Team B
        displayForTeamB(scoreTeamB);
        displayThreePointStatsForTeamB(amtThreePointsTeamB);
        displayTwoPointStatsForTeamB(amtTwoPointsTeamB);
        displayOnePointStatsForTeamB(amtOnePointTeamB);
        displayFoulStatsForTeamB(amtFoulsTeamB);
    }

    //The following 3 methods increase the score for Team A by X points + count the # of X-point shots.
    public void threePointsTeamA(View view) {
        scoreTeamA += 3;
        amtThreePointsTeamA += 1;
        displayForTeamA(scoreTeamA);
        displayThreePointStatsForTeamA(amtThreePointsTeamA); //to display the # of 3-point shots
    }

    public void twoPointsTeamA(View view) {
        scoreTeamA += 2;
        amtTwoPointsTeamA += 1;
        displayForTeamA(scoreTeamA);
        displayTwoPointStatsForTeamA(amtTwoPointsTeamA); //to display the # of 2-point shots
    }

    public void freeThrowTeamA(View view) {
        scoreTeamA += 1;
        amtOnePointTeamA += 1;
        displayForTeamA(scoreTeamA);
        displayOnePointStatsForTeamA(amtOnePointTeamA); //to display the # of 1-point shots
    }

    //The following 3 methods increase the score for Team B by X points + count the # of X-point shots.
    public void threePointsTeamB(View view) {
        scoreTeamB += 3;
        amtThreePointsTeamB += 1;
        displayForTeamB(scoreTeamB);
        displayThreePointStatsForTeamB(amtThreePointsTeamB); //to display the # of 3-point shots
    }

    public void twoPointsTeamB(View view) {
        scoreTeamB += 2;
        amtTwoPointsTeamB += 1;
        displayForTeamB(scoreTeamB);
        displayTwoPointStatsForTeamB(amtTwoPointsTeamB); //to display the # of 2-point shots
    }

    public void freeThrowTeamB(View view) {
        scoreTeamB += 1;
        amtOnePointTeamB += 1;
        displayForTeamB(scoreTeamB);
        displayOnePointStatsForTeamB(amtOnePointTeamB); //to display the # of 1-point shots
    }

    //To calculate the fouls + count the # of fouls
    public void foulTeamA(View view) {
        scoreTeamA -= 1;
        amtFoulsTeamA += 1;
        if (scoreTeamA < 0) { //basic check for negative numbers
            scoreTeamA = 0;
        }
        displayForTeamA(scoreTeamA);
        displayFoulStatsForTeamA(amtFoulsTeamA); //to display the # of fouls
    }

    public void foulTeamB(View view) {
        scoreTeamB -= 1;
        amtFoulsTeamB += 1;
        if (scoreTeamB < 0) { //basic check for negative numbers
            scoreTeamB = 0;
        }
        displayForTeamB(scoreTeamB);
        displayFoulStatsForTeamB(amtFoulsTeamB); //to display the # of fouls
    }

    //Displays the given score for Team A.
    public void displayForTeamA(int score) {
        teamAScore.setText(String.valueOf(score));
    }

    //Displays the given score for Team B.
    public void displayForTeamB(int score) {
        teamBScore.setText(String.valueOf(score));
    }

    //To display the stats for Team A
    public void displayThreePointStatsForTeamA(int score) {
        teamAThreePoints.setText("3 pts: "+String.valueOf(score));
    }

    public void displayTwoPointStatsForTeamA(int score) {
        teamATwoPoints.setText("2 pts: \u0020"+String.valueOf(score));
    }

    public void displayOnePointStatsForTeamA(int score) {
        //TextView scoreView = (TextView) findViewById(R.id.team_a_one_point);
        teamAOnePoint.setText("Free: \u0020"+String.valueOf(score));
    }

    public void displayFoulStatsForTeamA(int score) {
        teamAFouls.setText("Fouls: "+String.valueOf(score));
    }

    //To display the stats for Team B
    public void displayThreePointStatsForTeamB(int score) {
        teamBThreePoints.setText("3 pts: "+String.valueOf(score));
    }

    public void displayTwoPointStatsForTeamB(int score) {
        teamBTwoPoints.setText("2 pts: \u0020"+String.valueOf(score));
    }

    public void displayOnePointStatsForTeamB(int score) {
        teamBOnePoint.setText("Free: \u0020"+String.valueOf(score));
    }

    public void displayFoulStatsForTeamB(int score) {
        teamBFouls.setText("Fouls: "+String.valueOf(score));
    }

    //To reset the scores and stats for both teams + restarting the variables
    public void resetScores(View view) {
        scoreTeamA = 0;
        scoreTeamB = 0;

        //for Team A's stats
        amtThreePointsTeamA = 0;
        amtTwoPointsTeamA = 0;
        amtOnePointTeamA = 0;
        amtFoulsTeamA = 0;

        //for Team B's stats
        amtThreePointsTeamB = 0;
        amtTwoPointsTeamB = 0;
        amtOnePointTeamB = 0;
        amtFoulsTeamB = 0;

        //display the numbers
        displayForTeamA(scoreTeamA);
        displayForTeamB(scoreTeamB);

        //display stats for Team A
        displayThreePointStatsForTeamA(amtThreePointsTeamA);
        displayTwoPointStatsForTeamA(amtTwoPointsTeamA);
        displayOnePointStatsForTeamA(amtOnePointTeamA);
        displayFoulStatsForTeamA(amtFoulsTeamA);

        //display stats for Team B
        displayThreePointStatsForTeamB(amtThreePointsTeamB);
        displayTwoPointStatsForTeamB(amtTwoPointsTeamB);
        displayOnePointStatsForTeamB(amtOnePointTeamB);
        displayFoulStatsForTeamB(amtFoulsTeamB);
    }
}

