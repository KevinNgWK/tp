package command;

import canteens.Canteen;
import ui.Ui;
import java.util.ArrayList;
import java.util.Map;

public class DeleteStoreCommand extends Command {

    private int canteenIndex;
    private int storeIndex;

    public DeleteStoreCommand(int canteenIndex, int storeIndex) {
        this.storeIndex = storeIndex;
        this.canteenIndex = canteenIndex;
    }

    @Override
    public void execute(ArrayList<Canteen> canteens, Ui ui) {
        Canteen currentCanteen = canteens.get(canteenIndex);
        currentCanteen.deleteStore(storeIndex);
    }
}
