#include <iostream>
#include <cmath>

using namespace std;

class Point{
    protected:
        
        struct coordinates{
            float x;
            float y;
            float z;
                        
        };
    public:
        Point(){
            cout<<"Base constructor initiated"<<endl;
        }

        Point(float xn, float yn){
            crd.x = xn;
            crd.y = yn;                      
        }
        coordinates crd, sum_crd;
        string showPoint(){            
            string strng = ("(" + to_string(crd.x) + " : " + to_string(crd.y) + ")");
            return strng;
        }
        string showPoint(coordinates crd){
            string strng = ("(" + to_string(crd.x) + " : " + to_string(crd.y) + ")");
            return strng;
        }
        coordinates getPoint(){
            return crd;
        }                    
        void setPoint(float xn, float yn){
            crd.x = xn;
            crd.y = yn;
        }
        coordinates sumPoints(Point P){
            sum_crd.x = crd.x + P.crd.x;
            sum_crd.y = crd.y + P.crd.y;
            return sum_crd;                       
        }
        friend void originPrinter(Point P);   
        virtual void print(){ 
            
            cout <<"("<<crd.x<<" : "<<crd.y<<")"  << endl; 
        }
};

void originPrinter(Point P){
    float originDist = sqrt(pow(P.crd.x,2)+ pow(P.crd.y, 2));
    cout<<"Distance from the origin is "<<originDist<<"."<<endl;
}

class SpatialPoint : protected Point {
    public:
        void print(){
            cout <<"("<<crd.x<<" : "<<crd.y<<" : "<< crd.z << ")"  << endl;
        }
        SpatialPoint(){
            cout<<"Child constructor initiated"<<endl;
        }
        SpatialPoint(float x, float y, float z):Point(x, y){
            
            crd.z = z;            
        }
        void setPoint(float xn, float yn, float zn){
            crd.x = xn;
            crd.y = yn;
            crd.z = zn;
        }
        string showPoint(){            
            string strng = ("(" + to_string(crd.x) + " : " + to_string(crd.y) + " : " + to_string(crd.z) + ")");
            return strng;
        }
};


int main(){

    Point point1, point2;
    SpatialPoint point3;
    point1.setPoint(3.2, 4.3);
    point2.setPoint(1,2);
    point3.setPoint(3,4,5);
    cout<<point1.showPoint()<<endl;
    cout<<point2.showPoint()<<endl;
    cout<<point2.showPoint(point2.sumPoints(point1))<<endl;
    cout<<point3.showPoint()<<endl;
    originPrinter(point2);
    Point point4(3,2.2);
    SpatialPoint point5(1.2, 3.4, 5.6);
    
    Point *ptr[3];
    SpatialPoint *sptr[2];
    Point pts[3] = {point1, point2, point4};
    SpatialPoint spts[2] = {point3, point5};
    for(int i =0; i<5 ; i++){
        if (i<3){
            ptr[i] = &pts[i];
        }
        else{
            sptr[i-3] = &spts[i-3];
        }
    }
    for (int i=0; i<5;i++){
        if(i<=2){          
            Point a = *ptr[i];
            a.print();
        }
        else{
            SpatialPoint b = *sptr[i-3];
            b.print();
        }
    }
}





