#include <iostream>
#include <vector>
using namespace std;

class Substance{
    private:
        float pp, fp, chp;
        string name;
    public:
        Substance(){
        }
        Substance(float n_pp, float n_fp, float n_chp, string n_name){
            pp = n_pp;
            fp = n_fp;
            chp = n_chp;
            name = n_name;
        }
        void setPercentages(int protein, int fat, int carbohydrates){
            pp = protein/100.0;
            fp = fat/100.0;
            chp = carbohydrates/100.0;
        }
        void setName(string n){
            name = n;
        }
        float getProteinFraction(){
            return pp;
        }
        float getFatFraction(){
            return fp;
        }
        float getCarbFraction(){
            return chp;
        }
        string getName(){
            return name;
        }
};

class FoodComponent:public Substance{
    private:
        Substance sub;
        int amount;
        string name;
        
    public:
        FoodComponent(){}
        FoodComponent(Substance n_sub){
            sub=n_sub;
        }
        FoodComponent(Substance n_sub, int n_amount, string n_name){
            sub = n_sub;
            amount = n_amount;
            name = n_name;
        }
        float getProtein(){
            return (amount * sub.getProteinFraction());
        }
        float getFat(){
            float fatty = amount * sub.getFatFraction();
            return fatty;
        }
        float getCarbs(){
            return (amount * sub.getCarbFraction());
        }
        int getAmount(){
            return amount;
        }
        string getName(){
            return name;
        }
};

class FoodPortion{
    private:
        FoodComponent fc;
        vector<FoodComponent> listOfFcs;
        int sumMass;
    public:
        FoodPortion(){}
        FoodPortion(vector<FoodComponent> list){
            listOfFcs = list;
        }
        void setList(vector<FoodComponent> list){
            listOfFcs = list;
        }
        float getAllFoodMass(){
            sumMass=0;
            for(int i=0; i<listOfFcs.size(); i++){
                sumMass = sumMass + listOfFcs[i].getAmount();
            }
            return sumMass;
        }
        float getSpecificFoodMass(FoodComponent fc){
            return fc.getAmount();
        }
        string getSpecificName(FoodComponent fc){
            return fc.getName();
        }
        float getSpecificCustomComponentMass(float portionMass, FoodComponent fc){
            float mass = getAllFoodMass();
            float newMass = portionMass;
            float ratio = mass / newMass;
            return fc.getAmount() / ratio;
        }           
};

int main(){
    float x = 1400;
    Substance sub1;
    sub1.setName("Tomato");
    sub1.setPercentages(20, 20, 60);
    Substance sub2(0.6, 0.3, 0.1, "cucumber");
    Substance sub3(0.2, 0.5, 0.3, "sourcream");
    FoodComponent fc1(sub1, 300, "sliced tomatoes");
    FoodComponent fc2(sub2, 300, "sliced cucumbers");
    FoodComponent fc3(sub3, 100, "squirt of sourcream");
    cout<<sub1.getName()<<endl;
    cout<<sub1.getFatFraction()<<endl;
    cout<<fc1.getCarbs()<<endl;
    cout<<fc1.getAmount()<<"g of "<<fc1.getName()<<" contains "<<fc1.getFat()<<"g of fat apparently."<<endl;
    vector<FoodComponent> tomatoSaladCmps = {fc1, fc2, fc3};
    FoodPortion salad(tomatoSaladCmps);
    cout<<"tomato salad with standard portion size weighs approx "<<salad.getAllFoodMass()<<"g."<<endl;
    cout<<"For a salad with a mass of "<<x<<"g you will need:"<<endl;
    for(int i = 0; i < tomatoSaladCmps.size(); i++){
        cout<<salad.getSpecificCustomComponentMass(x,tomatoSaladCmps[i])<<"g of "<<salad.getSpecificName(tomatoSaladCmps[i])<<"."<<endl;
    }
    cout<<"Add salt to taste."<<endl;
    FoodComponent fc4(fc1, 300, "canned sliced tomatoes");
    cout<<"\n"<<fc4.getAmount()<<"g of "<<fc4.getName()<<" are just as good!!"<<endl;
    FoodComponent fc5(fc2);
    cout<<fc5.getName()<<" still weighs "<<fc5.getAmount()<<"g."<<endl;
}