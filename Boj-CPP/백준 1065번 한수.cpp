/*
어떤 양의 정수 X의 자리수가 등차수열을 이룬다면, 그 수를 한수라고 한다.
 등차수열은 연속된 두 개의 수의 차이가 일정한 수열을 말한다.
  N이 주어졌을 때, 1보다 크거나 같고, 
  N보다 작거나 같은 한수의 개수를 출력하는 프로그램을 작성하시오. 
입력
첫째 줄에 1,000보다 작거나 같은 자연수 N이 주어진다.
출력
첫째 줄에 1보다 크거나 같고, N보다 작거나 같은 한수의 개수를 출력한다.
*/
#include<iostream>
using namespace std;
int count(0);
void hansoo(int x)
{
	int a=x/100;
	int b=(x-(b*100))/10;
	int c=x-(b*100)-(c*10);
	if(a==0)
		count++;
		else
		{
			if((a-b)==(b-c)||(c-b)==(b-a))
			{
				count++;
			}
		}
}

int main()
{
	int num;
	cin>>num;
	int arr[1000];
	for(int i=1; i<=num; i++)
	{
		hansoo(i);
	}
	cout<<count<<endl;
}
