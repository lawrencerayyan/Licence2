package Session_1;


public class sousListe
{
     public static void sub_list_aux(Maillon e, Maillon m){
    if( e == null)return;
    if(e.getInfo()>0){
        m.setSucc(new Maillon(e.getInfo()));

    }
    sub_list_aux(e.getSucc(),m.getSucc());

}
public static List sub_list(List l){
    if(l == null) return null;
    List list_pos = new List(new Maillon());
    sub_list_aux(l.getList(),list_pos.getList());
    if(list_pos.getList().getSucc()!=null)
        list_pos.setList(res.getList().getSucc());
        return list_pos;
}
}
