/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package kasir;

/*
@author Adan Nugraha 202031242
*/

public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        try{ // Form_Siswa form = new Form_Siswa ();
        FormLogin form = new FormLogin();
        form.setVisible(true);
        }catch(Exception ex){
        System.out.println(ex.toString());
        }    
    }
    
}
