package trawnik;


public class Water_sprinkler  {
    
        private int x;
	private int y;
        int rotation; // obrot poszczegolnej podlewczki
	int type; // typ podlewaczki
        int use; //zeby dana podlewaczka dziala tylko raz 
	private boolean wasvisited;
        
        
        
        
        public void visit()
        {
        wasvisited = true;
        }

  

    public boolean wasVisited()
        {
        return wasvisited;
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
    
    
    	public Water_sprinkler(int x, int y, int rotation, int type, int use)
        {
        this.x = x;
        this.y = y;
        wasvisited = false;
        this.rotation  = rotation;
        this.type=type;
        this.use=use;
        }
    
    
}

