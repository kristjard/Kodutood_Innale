#include<iostream>
#include<vector>
#include<cmath>


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

template<typename T>
class Node{
    public:
        T data;
        Node* next;
        Node(T d){
            this -> data = d;
            this -> next = 0;
        }
        void insertNext(Node* n){
            n -> next = this -> next;
            this -> next = n;
        }
        void popNext(){
            Node* n = this -> next;
            this -> next = n-> next;
            delete n;
        }
};

class List : public Node<int>{
    public:
        List() : Node(0){}
        ~List(){
            while( this -> next !=0){
                this -> popNext();
            }
        }
        void print(){
            Node* n;
            cout<<"Linked list:"<<endl;
            n = this -> next;
            while(n != 0){
                cout << n -> data << endl;
                n = n -> next;
            }
        }

};

template<typename T, typename U>
class Templatious{
    private:
        T var;
        U var2;
    public:
        Templatious(){}
        Templatious(T n_var, U n_var2){
            var = n_var;
            var2 = n_var2;
        }
        void print(){
            cout<<"Variable 1 is "<<var<<" and variable 2 is "<<var2<<"."<<endl;
        }
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
    
    
    vector<int> ints = {1,2,3,4,5,6,-45,1,10001,78,-50};
    Point maxPoint = maxValue(points);
    printf("The point with the largest distance from the origin is: (%i, %i).\n", maxPoint.x, maxPoint.y);
    printf("The point p3 is the %i-th element in the vector points.\n",index(points, p3));
    List intList;
    for(int i = 0; i< ints.size(); i++){
        intList.insertNext(new Node<int>(ints[i]));
    }
    intList.print();
    Templatious<int, float> klazzy(1, 14.5);
    klazzy.print();
        
}