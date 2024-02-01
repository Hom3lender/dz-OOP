package persons.coordinates;

public class PersonPosition {
    private int x;
    private int y;

    public PersonPosition(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX(){
        return x;
    }

    public void setX(int x){
        this.x = x;
    }

    public int getY(){
        return y;
    }

    public void setY(int y){
        this.y = y;
    }

    public float getDistance(PersonPosition personPosition){
        float distance;
        int x1 = personPosition.x;
        int y1 = personPosition.y;

        distance = (float)Math.sqrt(Math.pow(this.x - x1, 2) + Math.pow(this.y - y1, 2));

        return distance;
    }

    public PersonPosition deltaCoordinatesToPerson(PersonPosition personPosition){
        return new PersonPosition(this.x - personPosition.getX(), this.y - personPosition.getY());
    }

    public boolean equals(PersonPosition personPosition) {
        return this.x == personPosition.getX() && this.y == personPosition.getY();
    }
}