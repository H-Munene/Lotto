package LottoCompany;

public interface LottoSys_interface {
    //abstract methods
    void generate_winning_numbers(); // generates the winning numbers
    void compare_selection_winNumbs(LottoPlayer player);/*compares selection and
     winning_numbers arraylists*/
    //void create_gameid(); //creates a unique gameid for an entry
}
