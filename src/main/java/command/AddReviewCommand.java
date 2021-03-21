package command;

import canteens.Canteen;
import exceptions.DukeExceptions;
import reviews.Review;
import stores.Store;
import ui.Ui;

import java.util.ArrayList;

public class AddReviewCommand extends Command {
    protected int storeIndex;
    protected String description;
    protected double rating;

    public AddReviewCommand(int storeIndex) {
        this.storeIndex = storeIndex;
        //enter review here
        Ui.enterReview();
        description =  Ui.readCommand();
        this.description = description;
        //enter rating here
        Ui.enterRating();
        rating = Double.parseDouble(Ui.readCommand());
        this.rating = rating;
        Ui.reviewAdded();
    }

    @Override
    public void execute(ArrayList<Canteen> canteens, Ui ui) throws DukeExceptions {
        Store currentStore = canteens.get(0).getStore(storeIndex);
        Review currentStoreReview = new Review(description,rating);
        currentStore.addReview(currentStoreReview);
    }

    @Override
    public boolean isExit() {
        return exit;
    }
}
