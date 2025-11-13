import java.util.Scanner;

public class PrisonBreakOut {
    // Scanner
    static Scanner kb = new Scanner(System.in);
    static String ans;

    static boolean isNight = false;
    static boolean hasLid = false;
    static boolean hasCards = false;
    static boolean hasFile = false;
    public static void main(String[] args) {
        System.out.println("You've been arrested and now, you need to escape.\nThe basic command is \"look\" which will give you infomation about your surrondings.\nYou can then use this information to figure out what you can do.\nAfter doing certan things you'll be returned to the center of your room where you can go to other areas.\ntype \"start\" to begin");
        ans = kb.next();
        if (ans.equals("start")) {
            System.out.println("You wake up in a cold cell.");
            ans = kb.next();
             if (ans.equals("look"));
             {
                System.out.println("You look around and see a toilet, a bed, a door, and a window. \nMaybe one of these can be used to escape.");
                start();
             }
        }
    }

    public static void welcome(){
        isNight = false;
        hasLid = false;
        hasCards = false;
        hasFile = false;
        ans = kb.nextLine();
        System.out.println("Type \"restart\" to try again.");
        if (ans.equals("restart")){
        System.out.println("You've been arrested and now, you need to escape.\nThe basic command is \"look\" which will give you infomation about your surrondings.\nYou can then use this information to figure out what you can do.\nAfter doing certan things you'll be returned to the center of your room where you can go to other areas.\ntype \"start\" to begin");
        ans = kb.next();
        if (ans.equals("start")) {
            System.out.println("You wake up in a cold cell.");
            ans = kb.next();
             if (ans.equals("look"));
             {
                System.out.println("You look around and see a toilet, a bed, a door, and a window. \nMaybe one of these can be used to escape.");
                start();
             }
        }
        } else {
            welcome();
        }
    }

     public static void start() {
                ans = kb.next();
                if (ans.equals("toilet")) {
                    System.out.println("You walk over to the toilet and take a look.");
                    if (hasLid == false){
                        System.out.println("The lid looks a little loose.\nMaybe it could be useful for something.");
                    }
                    toilet();
                } else if (ans.equals("bed")){
                    System.out.println("You walk over to the bed.\nThe ground underneath looks broken, maybe you could look at it.");
                    if (isNight == false){
                        System.out.println("The bed itself looks suprisingly comfy, maybe you could take a nap.");
                    }
                    bed();
                } else if (ans.equals("door")){
                    if ((hasFile == false) && (isNight == false))
                    {
                    System.out.println("You walk over to the door and hear another prisoner in the cell next to you.\n\"Hey dude do you have any cards?\nI'm trying to play go fish with Mr. Raspberry Jam\"");
                    door();
                    } else if ((hasFile == true) && (isNight == false))
                    {
                    System.out.println("You walk over to the door and hear another prisoner in the cell next to you.\n\"MR. RASPBERRY JAM I KNOW YOUR CHEATING >=(\"\nMaybe if you have something you could use it to try and remove those bars.");
                    door();
                    } else if (isNight == true){
                    System.out.println("You walk over to the door and hear another prisoner in the cell next to you snoring.\n\"I wuve you Mr. Rasberry Jam\"\nMaybe if you have something you could use it to try and remove those bars.");
                    door();
                    }
                } else if (ans.equals("window")){
                    System.out.println("You walk over to the window.\nIt's barred up, maybe you can use something to remove the bars.");
                    if ((hasFile == false) || (hasCards == false)) {
                        System.out.println("There's also a pack of cards just sitting there.");
                    }
                    window();
                } else if (ans.equals("look")){
                    System.out.println("You look around and see a toilet, a bed, a door, and a window. \nMaybe one of these can be used to escape.");
                    start();
                } else {
                    System.out.println("You can't do that. Maybe try something else.");
                    start();
                }
}

     public static void toilet() {
        ans = kb.next();
        if (ans.equals("take")){
            if (hasLid == true){
                System.out.println("You already took the toilet lid.");
                toilet();
            } else {
            System.out.println("You take the toilet lid, it looks like it could be useful as a shovel.\nMaybe you should explore the rest of your cell.");
            hasLid = true;
            start();
            }
        } else if (ans.equals("back")){
            System.out.println("You went back to the center of your room");
            start();
        } else if (ans.equals("look")){
             if (hasLid == true){
                System.out.println("There isn't much to look at.");
                toilet();
                } else{
                System.out.println("The toilet lid looks a little loose.\nMaybe it can ber useful for something.");
                toilet();
                }
            } else {      
            System.out.println("You can't do that. Maybe try something else or type \"back\" to go back.");
            toilet();
            }
    
    }
    public static void bed() {
        ans = kb.next();
        if (ans.equals("look")){
            System.out.println("The ground underneath the bed looks broken, maybe if you had a shovel you could try and dig your way out.");
            ans = kb.next(); 
            if (ans.equals("dig") && (hasLid == true)){
                System.out.println("Using the toilet lid your able to dig underneath the bed. \nSadly for you, you drop right into the employee break room. \nMaybe try something else next time");
                welcome();
            } else if (ans.equals("dig") && (hasLid == false)){
                System.out.println("Looks like you don't have anything to dig with.\nMaybe look around and see if you can find something.");
                start();
            }
        } else if (ans.equals("nap") || (ans.equals("sleep"))){
            if (isNight == true){
                System.out.println("You already took a nap, you don't need another one.");
                bed();
            } else{
            System.out.println("You took a nice relaxing nap and now its nightime.\nMaybe the guards are asleep and you should explore your cell more.");
            isNight = true;
            start();
            }
        } else if (ans.equals("back")){
            System.out.println("You went back to the center of your room");
            start();
        } else {
            System.out.println("You can't do that. Maybe try something else or type \"back\" to go back.");
            bed();
        }
    }

    public static void door() {
        ans = kb.next();
        if ((ans.equals("trade") && (hasCards == true) && (isNight == false)) || (ans.equals("give") && (hasCards == true) && (isNight == false))){
            System.out.println("You trade him your cards and in return he gives you a nail file.\nMaybe you could use this on something.");
            hasFile = true;
            start();
        } else if (ans.equals("file") && (hasFile == true)){
            if (isNight == true){
                System.out.println("You managed to escape your cell, nice job.\nNow you just need to get out of the jail.");
                escape();
            } else {
                System.out.println("You manage to file down the bars on the door and break out of your cell.\nSadly there was a guard right there.\nMaybe he leaves at night.");
                welcome();
            }
            } else if (ans.equals("back")){
            System.out.println("You went back to the center of your room");
            start();
        } else{
            System.out.println("You can't do that. Maybe try something else or type \"back\" to go back.");
            door();
        }
    }

    public static void window() {
        ans = kb.next();
        if (ans.equals("cards") || (ans.equals("take")) || (ans.equals("grab"))){
            if (hasCards == true){
                System.out.println("You already grabbed the cards.");
                window();
            }
            System.out.println("You grab the pack of cards.\nThey don't seem very useful for you.\nMaybe someone else could use them.");
            hasCards = true;
            start();
        } else if ((ans.equals("file")) && (hasFile == true)){
            System.out.println("You manage to file down the bars and get out.\n Luckly for you, you were only on the first floor.\nSadly there was a comedically placed shark pit that you fell into.\nMaybe try something else next time.");
            welcome();
        } else if ((ans.equals("file")) && (hasFile == false)){
            System.out.println("You don't have anthing to file with.\nMaybe try to find something to use.");
            start();
        } else if (ans.equals("look")){
            System.out.println("The window is barred, maybe you can use something you can remove the bars");
            if (hasCards == false){
                System.out.println("There's also a pack of cards just sitting there.");
            }
        } else if (ans.equals("back")){
            System.out.println("You went back to the center of your room.");
            start();
        } else {
            System.out.println("You can't do that. Maybe try something else or type \"back\" to go back.");
            window();
        }
    }

    public static void escape(){
        ans = kb.next();
        if (ans.equals("look")){
            System.out.println("You look around and see a right and a left path. Which one do you go down?");
            escape();
        } else if (ans.equals("right")){
            System.out.println("You go the right path and luckly for you there were no guards and you escaped through the fire exit.\nCongratulations!!!11!!");
        } else if (ans.equals("left")){
            System.out.println("You go the left path and unluckly for you there was a janator that just so happned to know Kung-Fo.\nAnd to make matters worse, he's really good at it.\nMaybe try something diffrent next time.");
            welcome();
        } else {
            System.out.println("You can't do that.");
            escape();
        }
    }

}


