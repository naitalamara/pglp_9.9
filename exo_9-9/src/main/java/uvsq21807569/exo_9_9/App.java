package uvsq21807569.exo_9_9;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

    	String cmd = "Ce1=cercle((14,1),3)";
    	String cmd2 = "Tr1=triangle((1,1),(3,3),(4,4))";
    	String cmd3 = "Ca1=carre((1,2),3)";
    	String cmd4 = "Re1=rectangle((6,6),3,6)";
    	String cmd5="move(c1,(12,4)) ";
    	String cmd7 ="afficher(a)";
    	String cmd6="delete(c1) ";
    	String[] separEgal = null;
    	
    	separEgal=cmd7.split("afficher");
    	System.out.println(separEgal[1]);
    	
    	separEgal=separEgal[1].split("[ ( ) ]");	
    	System.out.println(	"taille " +separEgal.length);
    	//System.out.println(cmd.indexOf("="));
    	for(String a :separEgal) {
    		System.out.println(a);
    		
    	}
    	
    }
}
