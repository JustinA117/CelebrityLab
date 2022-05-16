public class Celebrity{

private String name; 

private String clue; 
private String type;

public Celebrity(String name,String clue, String type){
this.name = name; 
this. clue = clue; 
this.type = type;
}

public String getName(){
    return name; 
}

public String getClue(){
    return clue; 
}

public String getType(){
return type;
}
public void checkClue(){
    System.out.println("Your clue is valid");

}


}
