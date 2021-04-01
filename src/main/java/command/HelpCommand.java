package command;

import canteens.Canteen;
import nusfoodreviews.NusFoodReviews;
import ui.Ui;

import java.util.ArrayList;
import java.util.Map;

public class HelpCommand extends Command {
    @Override
    public void execute(ArrayList<Canteen> canteens, Ui ui) {
        System.out.println("Enter 'menu' to view sample menu");
        System.out.println("Enter 'reviews' to show reviews of that particular store");
        System.out.println("Enter 'add' to add a new review");
        System.out.println("Enter 'home' to select a new canteen");
        System.out.println("Enter 'list' to select a new store");
        System.out.println("Enter 'exit' to exit the application");
    }
}
