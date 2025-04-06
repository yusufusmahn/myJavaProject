package OLDSNACKS;


import java.util.Scanner;

public class MBTI {
    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);

        String name = "";
        while (!name.equals("DONE")){
            System.out.print("Enter your name: ");
            name = keyboard.nextLine();
            if (name.equals("DONE"))break;

            int extroverted = 0;
            int introverted = 0;
            int sensing = 0;
            int intuitive = 0;
            int thinking = 0;
            int feeling = 0;
            int judging = 0;
            int perceptive = 0;

            String[] questions = {
                    "QUESION 1: expend energy, enjoy groups conserve energy (A)    -    enjoy one-on-one (B)",
                    "QUESION 2: interpret literally (A)   -    look for meaning and possibilities (B)",
                    "QUESION 3: logical, thinking (A)   -    questioning, empathetic, feeling, accommodating (B)",
                    "QUESION 4: organized, orderly (A)   -    flexible,adaptable (B)",
                    "QUESION 5: more outgoing, think out loud (A)   -    more reserved, think to yourself (B)",
                    "QUESION 6:practical,realistic, experiential (A)   -    imaginative, innovative, theoretical (B)",
                    "QUESION 7: candid, straight forward, frank (A)   -    tactful, kind, encouraging (B)",
                    "QUESION 8: plan,schedule (A)   -    unplanned, spontaneous (B)",
                    "QUESION 9: seek many tasks, public activities, interaction with others (A)   -   seek private, solitary activities with quiet to concentrate (B)",
                    "QUESION 10: standard, usual, conventional (A)   -    different,novel,unique (B)",
                    "QUESION 11: firm, tend to criticize, hold the line (A)   -    gentle, tend to appreciate, conciliate (B)",
                    "QUESION 12: regulated, structured (A)  -    easygoing, live and let live (B)",
                    "QUESION 13: external,communicative, express yourself (A)   -    internal, reticent, keep to yourself (B)",
                    "QUESION 14: focus on here-and-now (A)   -    look to the future,global perspective, bigpicture (B)",
                    "QUESION 15: tough-minded,just (A)   -    tender-hearted, merciful (B)",
                    "QUESION 16: preparation, plan ahead (A)   -    go with the flow, adapt as you go (B)",
                    "QUESION 17: active,initiate (A)   -    reflective, deliberate (B)",
                    "QUESION 18: facts, things, what is (A)   -   ideas, dreams, what could be, philosophical (B)",
                    "QUESION 19: matter of fact,issue-oriented (A)   -   sensitive, people-oriented, compassionate (B)",
                    "QUESION 20: control,govern (A)   -    latitude,freedom (B)"

            };


            for (int i = 0; i < questions.length; i++) {
                String answer = "";
                while (!answer.equals("A") && !answer.equals("B")) {
                    System.out.println(questions[i]);
                    answer = keyboard.nextLine().toUpperCase();

                    if (!answer.equals("A") && !answer.equals("B")) {
                        System.out.println("Please select A or B to proceed: ");

                    }
                }


                if (i == 0 || i == 4 || i == 8 || i == 12 || i == 16) {
                    if (answer.equals("A")){
                        extroverted++;

                    }

                    else{
                        introverted++;

                    }
                }


                else if (i == 1 || i == 5 || i == 9 || i == 13 || i == 17) {
                    if (answer.equals("A")){
                        sensing++;


                    }else{
                        intuitive++;


                    }
                }


                else if (i == 2 || i == 6 || i == 10 || i == 14 || i == 18) {
                    if (answer.equals("A")){
                        thinking++;


                    }else{
                        feeling++;

                    }
                }


                else if (i == 3 || i == 7 || i == 11 || i == 15 || i == 19) {
                    if (answer.equals("A")){
                        judging++;



                    }else{
                        perceptive++;


                    }
                }

            }



            String trait = "";


            if (extroverted > introverted) {
                trait += "E";

            } else{
                trait += "I";

            }

            if (sensing > intuitive) {
                trait += "S";

            } else{
                trait += "N";

            }

            if (thinking > feeling) {
                trait += "T";


            } else{
                trait += "F";


            }

            if (judging > perceptive){
                trait += "J";


            } else{
                trait += "P";

            }


            System.out.println("\nyour personality type is: "+ trait);
            System.out.println("=======================================================================================================================");
            System.out.println("Exploring the meaning of your personality type");
            System.out.println("-------------------------------------------------------------------------------------------------------------------------------------");
            System.out.println(getPersonalitySummaryText(trait));

        }
    }

    public static String getPersonalitySummaryText(String personalityType) {
        String summaryText = "";

        switch (personalityType) {
            case "ISFJ":
                summaryText = "Quiet, friendly, responsible, and conscientious. Committed and steady in meeting their obligations. Thorough, painstaking, and accurate. Loyal, considerate, notice and remember specifics about people who are important to them, concerned with how others feel. Strive to create an orderly and harmonious environment at work and at home";
                break;

            case "ISTJ ":
                summaryText = "Quiet, serious, earn success by being thorough and dependable. Practical, matter-of-fact, realistic, and responsible. Decide logically what should be done and work toward it steadily, regardless of distractions. Take pleasure in making everything orderly and organized—their work, their home, their life. Value traditions and loyalty.";
                break;

            case "INFJ":
                summaryText = "Seek meaning and connection in ideas, relationships, and material possessions. Want to understand what motivates people and are insightful about others. Conscientious and committed to their firm values. Develop a clear vision about how best to serve the common good. Organized and decisive in implementing their vision.";
                break;

            case "INTJ":
                summaryText = "Have original minds and great drive for implementing their ideas and achieving their goals. Quickly see patterns in external events and develop long-range explanatory perspectives. When committed, organize a job and carry it through. Skeptical and independent, have high standards of competence and performance—for themselves and others.";
                break;

            case "ISTP":
                summaryText = "Tolerant and flexible, quiet observers until a problem appears, then act quickly to find workable solutions. Analyze what makes things work and readily get through large amounts of data to isolate the core of practical problems. Interested in cause and effect, organize facts using logical principles, value efficiency.";
                break;

            case "ISFP":
                summaryText = "Quiet, friendly, sensitive, and kind. Enjoy the present moment, what's going on around them. Like to have their own space and to work within their own time frame. Loyal and committed to their values and to people who are important to them. Dislike disagreements and conflicts; don't force their opinions or values on others.";
                break;

            case "INFP":
                summaryText = "Idealistic, loyal to their values and to people who are important to them. Want to live a life that is congruent with their values. Curious, quick to see possibilities, can be catalysts for implementing ideas. Seek to understand people and to help them fulfill their potential. Adaptable, flexible, and accepting unless a value is threatened.";
                break;

            case "INTP":
                summaryText = "Seek to develop logical explanations for everything that interests them. Theoretical and abstract, interested more in ideas than in social interaction. Quiet, contained, flexible, and adaptable. Have unusual ability to focus in depth to solve problems in their area of interest. Skeptical, sometimes critical, always analytical.";
                break;


            case "ESTP":
                summaryText = "Seek to develop logical explanations for everything that interests them. Theoretical and abstract, interested more in ideas than in social interaction. Quiet, contained, flexible, and adaptable. Have unusual ability to focus in depth to solve problems in their area of interest. Skeptical, sometimes critical, always analytical.";
                break;

            case "ESFP":
                summaryText = "Outgoing, friendly, and accepting. Exuberant lovers of life, people, and material comforts. Enjoy working with others to make things happen. Bring common sense and a realistic approach to their work and make work fun. Flexible and spontaneous, adapt readily to new people and environments. Learn best by trying a new skill with other people.";
                break;


            case "ENTP":
                summaryText = "Quick, ingenious, stimulating, alert, and outspoken. Resourceful in solving new and challenging problems. Adept at generating conceptual possibilities and then analyzing them strategically. Good at reading other people. Bored by routine, will seldom do the same thing the same way, apt to turn to one new interest after another.";
                break;


            case "ESTJ":
                summaryText = "Practical, realistic, matter-of-fact. Decisive, quickly move to implement decisions. Organize projects and people to get things done, focus on getting results in the most efficient way possible. Take care of routine details. Have a clear set of logical standards, systematically follow them and want others to also. Forceful in implementing their plans.";
                break;

            case "ESFJ":
                summaryText = "Warmhearted, conscientious, and cooperative. Want harmony in their environment, work with determination to establish it. Like to work with others to complete tasks accurately and on time. Loyal, follow through even in small matters. Notice what others need in their day-to-day lives and try to provide it. Want to be appreciated for who they are and for what they contribute.";
                break;


            case "ENFJ":
                summaryText = "Warm, empathetic, responsive, and responsible. Highly attuned to the emotions, needs, and motivations of others. Find potential in everyone, want to help others fulfill their potential. May act as catalysts for individual and group growth. Loyal, responsive to praise and criticism. Sociable, facilitate others in a group, and provide inspiring leadership.";
                break;

            case "ENTJ":
                summaryText = "Frank, decisive, assume leadership readily. Quickly see illogical and inefficient procedures and policies, develop and implement comprehensive systems to solve organizational problems. Enjoy long-term planning and goal setting. Usually well informed, well read, enjoy expanding their knowledge and passing it on to others. Forceful in presenting their ideas.";
                break;

            case "ENFP":
                summaryText = "Warmly enthusiastic and imaginative.  See life as full of possibilities. Make connections between events and information very quickly, and confidently proceed based on the patterns they see. Want a lot of affirmation from others, and readily give appreciation and support. Spontaneous and flexible, often rely on their ability to improvise and their verbal fluency.";
                break;

            default:
                summaryText = "Try agin to find personality type";
                break;

        }
        return summaryText;
    }

}
