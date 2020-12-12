#include<iostream>
#include<vector>
#include<cmath>
#include<type_traits>

using namespace std;

/* Loo klass Punkt ja sellele liitmise operaator nõnda, et
  liitmise malliga funktsioon toimiks ka Punkti puhul.*/

class Point{
    public:
        int x;
        int y;

        Point() {}
        Point(int n_x, int n_y){
            x = n_x;
            y = n_y;
        }
        Point operator + (const Point& param){
            Point temp;
            temp.x = x + param.x;
            temp.y = y + param.y;
            return temp;
        }
        friend bool operator == (Point p1, Point p2){
            if(p1.x == p2.x && p1.y == p2.y){
                return true;
            }
            else{
                return false;
            }
        }

        friend float getDistFromOrigin(Point p){ //kuna kahe punkti suuruse võrdlemine on nonsense siis arvutan kauguse nullpunktist, mida annab võrrelda.
            return sqrt(pow(p.x,2)+ pow(p.y, 2));
        }
};

/* Loo mallfunktsioon massiivist suurima elemendi leidmiseks.
    Hoolitse, et see töötaks ka Punkti ja Kellaaja korral.*/
template <typename T>
T maxValue(vector<T> values){
    float temp = 0;
    int x = 0;
    if(typeid(T) == typeid(Point)){
        vector<float> newValues;
        for (int i=0; i < values.size(); i++ ){
            newValues.push_back(getDistFromOrigin(values[i]));
            if(newValues[i] > temp){
                temp = newValues[i];
                x = i;
            }
        }    
    }
    
    return values[x];
}



template <typename T>
int index(vector<T> values, T value){
    int ndx = 0;
    for(int i = 0; i < values.size(); i++){
        if(value == values[i]){
            ndx = i;
        }
    }
    return ndx;
}


struct Link{
    public:
    
    string data;
    Link* nextLink;

    Link(string newData){
        this->data = newData;
        this->nextLink = 0;
    }
    void addLink(Link* l){
        l->nextLink = this -> nextLink;
        this -> nextLink = l;
    }
    void removeLink(){
        Link* l = this -> nextLink;
        this -> nextLink = l -> nextLink;
        delete l;
    }
};

struct Chain : public Link{
    public:
        Chain() : Link(){}


};

int main(){
    Point p1(2, 4);
    Point p2(4, 2);
    Point p3(-2, 3);
    Point sumPoint;
    sumPoint = p1 + p2; 
    printf("Sum of two points is (%i, %i).", sumPoint.x, sumPoint.y);

    /* Leia  punktimassiivis olevate punktide koordinaatide kokkuliitmisel saadava punkti 
    koordinaatide väärtused.*/
    Point newPoint(0,0);
    vector<Point> points = {p1, p2, p3, sumPoint};
    for (Point point : points){
        newPoint = newPoint + point;
    }
    printf("\nSum of all points is (%i, %i).\n", newPoint.x, newPoint.y);
    
    
    vector<float> ints = {1,2,3,4,5,6,-45,1,10001.6,78,-50};
    Point maxPoint = maxValue(points);
    printf("The point with the largest distance from the origin is: (%i, %i).\n", maxPoint.x, maxPoint.y);
    printf("The point p3 is the %i-th element in the vector points.",index(points, p3));
    
}