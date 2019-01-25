#include <iostream>
using namespace std;
 
int main()
{
    int C;
	cin>>C;
    for(int i = 0; i < C; i++)
    {
        int N, score[1000], sum = 0, cnt = 0, pass = 0;
        cin>>N;
        for(int j = 0; j < N; j++)
        {
            cin>>score[j];
            sum += score[j];
            cnt++;
        }
        for(int j = 0; j < cnt; j++)
        {
            double avg = (double)sum/cnt;
            
            if(avg < score[j]) pass++;
        }
        cout<<fixed;
        cout.precision(3);
        cout<<(double)pass/cnt*100<<"%"<<endl;
    }
    return 0;
}
