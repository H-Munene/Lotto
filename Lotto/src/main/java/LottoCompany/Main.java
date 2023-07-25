package LottoCompany;

import LottoCompany.player.LottoPlayer;
import LottoCompany.sys.LottoSys;

public class Main {
    public static void main(String[] args){
        LottoPlayer instance1 = new LottoPlayer();

        LottoSys instance2 = new LottoSys();
        instance2.compare_selection_winNumbs(instance1);

        }
}

