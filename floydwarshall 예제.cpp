#include<iostream>
#include<algorithm>
using namespace std;

int number(4);
int INF=1000000;

int a[4][4]={
	{0,5,INF,8},{7,0,9,INF},
	{2,INF,0,4},{INF,INF,3,0}	
};
void floydwarshall()
{
	//결과그래프 초기화
	int d[number][number];
	for(int i=0; i<number; i++)
	{
		for(int j=0; j<number; j++)
		d[i][j]=a[i][j];
	 } 
	 for(int k=0; k<number; k++)
	 {
	 	//i=출발노드
		 for(int i=0; i<number; i++)
		 {
		 	//j 도착노드
			 for(int j=0; j<number; j++)
			 {
			 	if(d[i][k]+d[k][j] < d[i][j])
			 	d[i][j]=d[i][k]+d[k][j];
			  } 
		  } 
	 }
	 for(int i=0; i<number; i++)
	 {
	 	for(int j=0; j<number; j++)
	 	cout<<d[i][j]<<" ";
	 	cout<<"\n";
	 }
}
int main()
{
	floydwarshall();
}
