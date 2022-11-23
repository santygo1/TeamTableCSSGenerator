package org.example;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author Danil on 22.11.2022
 * @project CSSTableGenerator
 */
public class Generator {

    private final List<String> tournamentImageNames;
    private final List<String> teamImageNames;

    Generator(File tournamentsFolder, File teamsFolder) {
        tournamentImageNames = loadImageNamesFromFolder(tournamentsFolder);
        teamImageNames = loadImageNamesFromFolder(teamsFolder);
    }

    private List<String> loadImageNamesFromFolder(File folder) {
        List<File> allFiles = List.of(Objects.requireNonNull(folder.listFiles())); //getting files from folder
        List<String> imageNames = new ArrayList<>();    // list of file names
        for (File file : allFiles) imageNames.add(file.getName());

        return imageNames;
    }

    private Tournament generateTournament() {
        int randomTournamentIndex = (int) (Math.random() * tournamentImageNames.size());

        return new Tournament(tournamentImageNames.get(randomTournamentIndex));
    }

    private Date generateDate() {
        int day = (int) (Math.random() * 28) + 1;   //1-28
        int month = (int) (Math.random() * 12) + 1;     //1-12
        int year = 2013 + (int) (Math.random() * 10);    //2013-2022

        return new Date(day, month, year);
    }

    private Team generateTeam() {
        int randomTeamIndex = (int) (Math.random() * tournamentImageNames.size());

        return new Team(teamImageNames.get(randomTeamIndex));
    }

    private Score generateScore() {
        int[] bo = new int[]{3, 5};
        int randomBO = (int) (Math.random() * bo.length);
        int roundsTotal = bo[randomBO];
        int firstTeamRoundsWon = (int) (Math.random() * roundsTotal);
        int secondTeamRoundsWon;
        if (firstTeamRoundsWon != 0) secondTeamRoundsWon = roundsTotal - firstTeamRoundsWon;
        else {
            switch (bo[randomBO]) {
                case 3 -> secondTeamRoundsWon = 2;
                case 5 -> secondTeamRoundsWon = 3;
                default -> throw new IllegalArgumentException("Best of ?");
            }
        }

        return new Score(firstTeamRoundsWon, secondTeamRoundsWon);
    }

    public void generate(File outputFilePath, int countOfRow) {
        Team SKGaming = new Team("sk gaming.png");

        try (FileWriter fileWriter = new FileWriter(outputFilePath, false)){
            for (int i = 0; i < countOfRow; i++) {
                fileWriter.write("\t\t\t\t\t");
                fileWriter.write("<tr>\n");

                Tournament tournament = generateTournament();
                fileWriter.write("\t\t\t\t\t\t");
                fileWriter.write(tournament.toString());
                fileWriter.append('\n');
                fileWriter.append('\n');

                Date date = generateDate();
                fileWriter.write("\t\t\t\t\t\t");
                fileWriter.write(date.toString());
                fileWriter.append('\n');
                fileWriter.append('\n');

                Team team = generateTeam();
                Score score = generateScore();
                int SKGamingPosition = (int) (Math.random() * 2);

                Team left, right;
                if (SKGamingPosition == 0) {
                    left = SKGaming;
                    right = team;
                } else {
                    left = team;
                    right = SKGaming;
                }

                fileWriter.write("\t\t\t\t\t\t");
                fileWriter.write(left.toString());
                fileWriter.append('\n');
                fileWriter.append('\n');

                fileWriter.write("\t\t\t\t\t\t");
                fileWriter.write(score.toString());
                fileWriter.append('\n');

                fileWriter.write("\t\t\t\t\t\t");
                fileWriter.write(right.toString());
                fileWriter.append('\n');

                int countOfKills = (int) (Math.random() * 100) + 70;
                Number kills = new Number(countOfKills);
                fileWriter.write("\t\t\t\t\t\t");
                fileWriter.write(kills.toString());
                fileWriter.append('\n');
                fileWriter.append('\n');

                Number dies = new Number(countOfKills + (int) (Math.random() * 4) - 2);
                fileWriter.write("\t\t\t\t\t\t");
                fileWriter.write(dies.toString());
                fileWriter.append('\n');

                Number helps = new Number((int) (Math.random() * 50) + 50);
                fileWriter.write("\t\t\t\t\t\t");
                fileWriter.write(helps.toString());
                fileWriter.append('\n');

                Number fiveKills = new Number((int) (Math.random() * 5) + 2);
                fileWriter.write("\t\t\t\t\t\t");
                fileWriter.write(fiveKills.toString());
                fileWriter.append('\n');

                Number fourKills = new Number((int) (Math.random() * 10) + 2);
                fileWriter.write("\t\t\t\t\t\t");
                fileWriter.write(fourKills.toString());
                fileWriter.append('\n');

                Number threeKills = new Number((int) (Math.random() * 15) + 2);
                fileWriter.write("\t\t\t\t\t\t");
                fileWriter.write(threeKills.toString());
                fileWriter.append('\n');

                fileWriter.write("\t\t\t\t\t");
                fileWriter.write("</tr>\n");
                fileWriter.append('\n');
            }

            fileWriter.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public static void main(String[] args) {
        File tournamentsFolder = new File("D:\\Сайт\\source\\assets\\img\\tournaments");
        File teamsFolder = new File("D:\\Сайт\\source\\assets\\img\\teams");
        Generator generator = new Generator(tournamentsFolder, teamsFolder);

        File outputFile = new File("D:\\table.txt");
        generator.generate(outputFile, 200);
    }
}
