#include<iostream>
#include<cstring>
using namespace std;

class stack{
   public:
   int topindex=-1;
   int arr[10000];
   
      
      int empty()
      {
         if(topindex<0)
         return 1;
         else
         return 0;
      }
      void push(int data)
      {
         topindex++;
         arr[topindex]=data;
         
      }
      void pop()
      {
         if(topindex<0)
         cout<<"-1"<<"\n";
         else
         {
         cout<<arr[topindex]<<"\n";
         topindex--;
         }
      }
      void top()
      {
      	if(topindex<0)
      	cout<<"-1"<<"\n";
      	else
         cout<<arr[topindex]<<"\n";
      }
      
};
int main()
{   stack s;
   int a;
   
   cin>>a;
   char av[10];
   for (int i=0; i<a; i++)
   {   
      cin>>av;
      if(!strcmp(av,"push"))
      {   int x;
         cin>>x;
         s.push(x);
      }
      else if(!strcmp(av,"pop"))
      {
         s.pop();
      }
      else if(!strcmp(av,"empty"))
      {
         cout<<s.empty()<<"\n";
      }
      else if(!strcmp(av,"top"))
      {
         s.top();
      }
      else
      {
         cout<<s.topindex+1<<"\n";
      }
   }
}
