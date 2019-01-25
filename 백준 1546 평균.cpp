/*예를 들어, 
세준이의 최고점이 70이고, 
수학점수가 50이었으면 수학점수는 
50/70*100이 되어 71.43점이 된다.
첫째 줄에 시험 본 과목의 개수 N이 주어진다. 이 값은 1000보다 작거나 같다.
 둘째 줄에 세준이의 현재 성적이 주어진다. 
이 값은 100보다 작거나 같은 음이 아닌 정수이고, 적어도 하나의 값은 0보다 크다.
*/
#include<iostream>
using namespace std;

int main()
{
	int line_num;
	cin>>line_num;
	float arr[line_num];
	float max(0);
	float sum(0);
	
	for(int i=0; i<line_num; i++)
	{
		cin>>arr[i];
		if(arr[i]>max)
		max=arr[i];

	}
	for(int i=0; i<line_num; i++)
	sum+=(arr[i]/max)*100;
	
	cout<<sum/line_num<<endl;
}
