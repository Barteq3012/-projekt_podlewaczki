package trawnik;


public class Water_sprinkler  {
    
        private int x;
	private int y;
	int type; // typ podlewaczki
        int rotation; // obrot poszczegolnej podlewczki
        int use; //zeby dana podlewaczka dziala tylko raz 
	private boolean wasvisited;// potrzebne do circle_version w Setup
	
    public void visit()
        {
        wasvisited = true;
        }
    public int getX()
        {
        return x;
        }
     public int getY()
        {
        return y;
        }
      public int getRotation()
        {
        return rotation;
        }
       public int getType()
        {
        return type;
        }
       public int getUse()
        {
        return use;
        }
    
    public boolean wasVisited()
        {
        return wasvisited;
        }
    
    	public Water_sprinkler(int x, int y, int type, int rotation, int use)
        {
        this.x = x;
        this.y = y;
	this.type=type;
        this.rotation  = rotation;
        this.use=use;
	wasvisited = false;
        }
    
    
}

