#include<cstdio> 
#include<ctime> 
#include<conio.h> 
#include<windows.h>
#include<cstdlib> 
#include<cstring>
#include<iostream>
#include <cmath>
 #include<fstream>
#define SIZE 200

#define MYPI 3.141592/////바이오리듬하기위해서 설정해놓은것입니당  
using namespace std;
/////////깔끔하게보이기위해서 함수사용한걸 앞에 나열  
char* salloc(int len);	//0.문자열 동적할당 
void input_data(char *buf, char *who);	//1.문자열을 입력받음 c
char* search_question(char *input, int teach);	//2.질문에 대한 대답을 찾아서 리턴, 없으면 "" 
void print_answer(char *output);	//3.대답을 프린트 해줌 
void teach_answer(char *buf);	//4.대답을 파일에 입력하게함 
void next_line(FILE *file, int line);	//5.line만큼 다음줄로 이동 
char* nfgets(char *buf, int max, FILE *file);	//6.개행문자를 빼고 파일입력 
void log_save(char* input, char* output, char* user_name); //7.Log파일 생성 
int filtering(char *input);	//8.욕 필터링 
void textcolor(int color_number);	//0 - 검정색/*1 - 파랑색2 - 초록색3 - 옥색4 - 빨간색5 - 자주색6 - 노랑색7 - 흰색8 - 회색9 - 연한 파랑색
void calendar(int year,int month);///달력기능 추가 위해서  
int isLunarYear(int _year);
int howManyDaysInMonthOfYear(int _year, int _month);
int howManyDays(int _year, int _month, int _day);

static int TODAY_DAY=21;
static int TODAY_YEAR=2017;
static int TODAY_MONTH=12;
class baseballgame 
{ 
private:  
  int number[3]; // 3자리 숫자를 만들기위해
public: 
  baseballgame(){
  srand((unsigned)time(NULL)); 
  number[0] = rand() % 10; 
  // 아래 do while은 첫번째 숫자와 중복되지 않게 하기 위해서. 
  do{ 
      number[1] = rand()%10; //난수생 
  } while(number[0] == number[1]); 
 
  do { 
      number[2] = rand()%10; //  난수생 
  } while((number[2] == number[1]) || (number[2] == number[0])); 
} 
  
  int CountOfStrike(int parm_guess[]){
  	int count = 0; 
  for(int i = 0; i < 3; i++){ 
      if(number[i] == parm_guess[i]) count++; 
  } 

  return count; 
} 
  
  int CountOfBall(int parm_guess[]){
  	int count = 0; 

  for(int i = 0; i < 3; i++){ 
      for(int j = 0; j < 3; j++) 
          if((i != j) && (number[i] == parm_guess[j])) count++; 
  } 

  return count; 
} 
  
  void ShowScoreData(){
  	cout << "정답은 [" << number[0] << number[1] << number[1] << "]입니다." << endl;
  }
}; 


/////////////////////////////여기서부터 메인함수  
int main() { 
MessageBoxA(NULL, "jarvis는 주인의 물음에 대답합니다   \n jarvis 를 가르치고 싶다면 \"/t 질문\" 형식으로 써주세요. \n+)대화를 종료하고 싶다면 \"종료 \"를 입력해 주세요\n 수정자 : 장진성,김준성", "jarvis 사용설명서", MB_OK); 
int i, j, k; 
char *buf; int teach; char *input; char *output; char user_name[20]; 
buf = salloc(SIZE); 
srand((unsigned)time(NULL)); input_data(user_name, "당신의 이름");
while (true) { teach = 0;  
input_data(buf, user_name); //buf에 입력받음 
input = salloc(strlen(buf) + 1); //input을 buf크기만큼 동적할당(널문자 포함) 
strcpy(input, buf); //input에 buf를 넣음 //INPUT CHECK 
if (filtering(input) == 1) { //욕검출시 intput free하고 continue() 
free(input); continue; }	
if (!strcmp("종료", input)) {	//"잘가"입력시 심심이 종료 
MessageBoxA(NULL, "jarvis를 종료합니다. \n수정자 : 장진성,김준성 ", "jarvis : 주인님 다음에 뵙겠습니다", MB_OK); 
break; } 
if(!strcmp("게임",input)){
	
	MessageBoxA(NULL, "야구게임 20회안에 맞추어야합니다. ", "jarvis : 주인님 간단한 게임 준비했습니다.", MB_OK); 
	 

	baseballgame mygame; 
  int strike = 0, ball = 0, guess[3];  /////난수 생성시작  
    for(int count = 1; count <= 20; count++){ 
      cout << endl << "[" << count << "] 세자리 숫자를 추측해보십쇼> :"; 
       for(int i = 0; i < 3; i++){
	    cin >> guess[i];
	    
	}	
      strike = mygame.CountOfStrike(guess);  // 스트라이크의 갯수를 구하는 함수 호출 
      ball = mygame.CountOfBall(guess);      // 볼의 갯수를 구하는 함수 호출.. 

      cout << "[" << strike << "]스트라이크 [" << ball << "]볼" << endl; 

      // 스트라이크가 3개라면 숫자를 맞춘것이다. 
      if(strike == 3){ 
          cout << count + 1 << "회만에 성공하셨습니다.주인님 " << endl; 
          
          break;
		  
      } 

      if(strike != 3 && count == 19){ 
          cout << "20회의 횟수를 초과하였습니다 주인님 " << endl; 
          mygame.ShowScoreData(); 
          break; 
      } 
  }  


} 
if (!strcmp("달력",input)){
		MessageBoxA(NULL, "달력 기능을 구현합니다 ", "jarvis : 주인님 원하는 년도와 달을 입력하시면 됩니다 .", MB_OK);
			
				int year=0,month=0;
	cout<<"연수를 입력하시오";cin>>year;
	cout<<endl;
	cout<<"달수를 입력하세요";cin>>month;
	cout<<endl;
	cout<<"일\t 월\t 화\t 수\t 목\t 금\t 토"<<endl;
	calendar(year,month);
} 
if(!strcmp("바이오리듬",input)){
	MessageBoxA(NULL,"바이오 리듬을 구현합니다 ","jarvis:주인님의 오늘 신체,감정,지능 수치를구현하겠습니다",MB_OK);
	int y;
	int m;
	int d;
	cout<<"태어난 년도를 입력하세요 ";cin>>y;
	cout<<endl;
	cout<<"태어난 달을 입력하세요 ";cin>>m;
	cout<<"태어난 일을 입력 하세요 ";cin>>d;
	int days = howManyDays(y, m, d);
	cout<<"생년월일"<<y<<"년"<<m<<"월"<<d<<"일 출생한"<<endl; 
	cout<<"주인님은"<<TODAY_YEAR<<"년"<<TODAY_MONTH<<"월"<<TODAY_DAY<<"일기준으로"<<days<<"일 만큼 사셨습니다"<<endl;
	double physical = sin((2.0*MYPI*days) / 23.0);
	double emotional = sin((2.0*MYPI*days) / 28.0);
	double intelligence = sin((2.0*MYPI*days) / 33.0);
	cout<<"신체지수:"<<physical<<endl;
	cout<<"감정지수:"<<emotional<<endl;
	cout<<"지성지수:"<<intelligence<<endl;
	

	
	
}
if (!strncmp(input, "/t ", 3)) { //if 심심이 가르치기 /t 질문 형식 일때 
input = input + 3; //앞에 '/t '를 input에서 지움 
teach = 1; }

strcpy(buf, search_question(input, teach)); 
//input에 맞는 output을 찾아서 buf에 저장, 없으면 NULL 
output = salloc(strlen(buf) + 1); //output을 buf크기만큼 동적할당(널문자 포함) 
strcpy(output, buf); //output에 buf를 넣음 

if (strcmp(output, "")) { //-질문에 대한 대답있을경우 
if (teach == 1) { // 가르치기 상태일때 
cout<<"이미 jarvis가 알고있는 질문입니다"<<endl<<endl;
input = input - 3; //할당 받은 만큼 free하기 위해 다시 input의 크기를 원래대로 해줌 
} 
else { log_save(input, output,user_name); //INPUT과 OUTPUT이 정상적으로 출력되었을때 저장 
} 
print_answer(output); //output을 출력 
} 
else { //-질문에 일치하는 대답이 없을경우 
cout<<"jarvis는 학습능력이있는로봇입니다 가르쳐 주세요"<<endl<<endl; 
teach_answer(input); //jarvis 가르치기 
if (teach == 1) 
input = input - 3; //할당 받은 만큼 free하기 위해 다시 input의 크기를 원래대로 해줌 
} //FREE 
free(input); 
free(output); }
 }

char* salloc(int len) { 
return (char*)malloc(sizeof(char)*len); //len 만큼 동적할당 
}

void input_data(char *buf, char *who) { 
fflush(stdin); //입력장치 초기화 
while (true) { //아무것도 입력안하면 반복 -> 입력할때 까직 반복	//누구 : 
textcolor(2); cout<<who<<":";  
textcolor(7); nfgets(buf, SIZE, stdin); cout<<endl; //내용을 SIZE만큼 프린트 stdin -> 출력장치 
if (strcmp(buf, "")) 
break; //입력되면 반복문 탈출 
} 
}

char* search_question(char *input, int teach) { 
FILE *fp; int output_num, random, check = 0, i; 
char *buf; char *similar; buf = salloc(SIZE); similar = salloc(SIZE); 
if ((fp = fopen("질문지.txt", "r")) == NULL) 
return ""; //파일이 없으면 리턴 

for (i = 0; i < 2; i++) { //총 2번 파일을 탐색 i - 0.완벽히 일치하는가, 1.조금 일치하는가 
while (!feof(fp)) { //파일 끝까직 탐색 
fscanf(fp, "%d", &output_num); //질문의 답이 몇개인지 output_num에 저장 
nfgets(buf, SIZE, fp); //buf에 질문 저장 
if (i == 0 && !strcmp(input, buf)) check = 1;//질문과 완벽히 일치하는가 
if (i == 1 && strlen(buf) > 3 && strstr(input, buf) != NULL) { //if 유사한 질문이 있는가 
check = 1; 
if (teach == 0) 
printf("\n원하는 대답이 아닐경우 \"/t 질문\" 을 통해 가르쳐 주세요.\n\n"); } 
if (check == 1) { 
random = rand() % output_num; //질문의 답중 출력할 답을 랜덤으로 설정 
next_line(fp, random); //출력할 대답으로 이동 
nfgets(buf, SIZE, fp); //대답을 buf에 저장 
fclose(fp); return buf; //저장한 대답을 리턴 
} 
next_line(fp, output_num + 1); //다음 질문이 있는 파일위치로 이동 
} 
if (teach == 1) 
break; 
rewind(fp); //파일탐색 위치를 처음으로 돌림 
} fclose(fp); 
return ""; }

void print_answer(char *output) { textcolor(14); 
cout<<"┌─jarvis──────────────────────────────────"<<endl; 
cout<<output<<endl; 
cout<<"└──────────────────────────────────────┘"<<endl<<endl; 
textcolor(10); 
}

void teach_answer(char *input) { 
char buf[SIZE]; int num, i; FILE *fp; fp = fopen("질문지.txt", "a"); 
textcolor(14); printf("가르칠 대답의 갯수를 입력해 주세요( 0 입력시 스킵 )"); 
textcolor(7); scanf("%s", &buf); num = atoi(buf); 
if (num == 0) { 
fclose(fp); return; 
} 
fprintf(fp, "%d%s\n", num, input); //대답의 갯수와 질문을 저장 3안녕
for (i = 0; i < num; i++) { //대답의 갯수만큼 for문 안녕안녕 
input_data(buf, "TEACH"); //TEACH : 대답을 입력받음 웅 안녕 
fprintf(fp, "%s\n", buf); //입력받은 대답을 파일에 저장 반가워 
} fprintf(fp, " \n"); //공백 처리 
fclose(fp); }

void next_line(FILE *file, int line) { 
int i;
 for (i = 0; i < line; i++) { 
 while (!feof(file)) { if (fgetc(file) == '\n') 
 break; 
 }
  }
   } 

char* nfgets(char *buf, int max, FILE *file) { 
fgets(buf, max, file); //한줄불러옴 
buf[strlen(buf) - 1] = '\0'; //개행문자(엔터)를 제거해줌 
return buf; //개행문자 제거한걸 리턴
 }

void log_save(char* input, char* output, char* user_name){ 
FILE *fp; 
fp = fopen("대화기록.txt", "a"); 
fprintf(fp, "%s : %s \n jarvis : %s\n", user_name, input, output); fclose(fp); 
}

int filtering(char *input) { int i, j; if (strstr(input, "시발") != NULL || strstr(input, "개새끼") != NULL) { 
for (i = 0; i < 5; i++) { 
MessageBoxA(NULL, "욕하지마세요.\n주인님 ?\n안하실거죠??", "욕하지맙시다!", MB_OK); { } 
for (j = 0; j < 2; j++){ 
MessageBoxA(NULL, "욕하지마세요.\n jarvis는욕 싫습니다 ?\n진짜진짜진짜안하실거죠??", "욕하지맙시다!", MB_OK); 
}
 } 
 return 1; 
 } 
 return 0; 
 }
 
 void calendar(int year,int month){
	int day[12]={31,28,31,30,31,30,31,31,30,31,30,31};
	int days=0;
	int firstdate=0;
	int count=0;
	days=(year-1)*365+(year-1)/4-(year-1)/100+(year-1)/400;
	for(int i=0;i<month-1;i++){
		if(i==1){
			if((year%4==0&&year%100!=0)||year%400==0)
			day[1]=29;
			else
		day[1]=28;
		}
		days+=day[i];
	}
	firstdate=days%7;
	for(int i=0;i<=firstdate;i++){
		printf("\t");
		count++;
	}
	for(int i=1;i<=day[month-1];i++){
		if(count>=7){
			cout<<endl;
			count=0;
		}
		cout<<i<<"\t";
		count++;
	}
	cout<<endl<<endl;

}
int isLunarYear(int _year)
{
	if (((_year % 4) == 0 && (_year % 100) != 0) || 
		(_year % 400) == 0)
	{
		return 1;
	}
	return 0;

}

int howManyDaysInMonthOfYear(int _year, int _month)
{
	int monthData[] = {0,31, 28, 31, 30, 31, 30, 31,31,30,31,30,31 };
	
	if (isLunarYear(_year) == 1 && _month == 2)
	{
		return 29;
	}
	else
	{
		return monthData[_month];
	}
}

int howManyDays(int _year, int _month, int _day)
{
	int days = 0;
	// year-based counting
	for (int i = _year+1; i < TODAY_YEAR; i++)
	{
		if (isLunarYear(i) == 1)
		{
			days = days + 366;
		}
		else
		{
			days = days + 365;
		}
	}
	for (int i = _month + 1; i <= 12; i++)
	{
		days = days + howManyDaysInMonthOfYear(_year, i);
	}
	for (int i = 1; i <= (TODAY_MONTH-1); i++)
	{
		days = days + howManyDaysInMonthOfYear(TODAY_YEAR, i);
	}
	days = days + TODAY_DAY;
	days = days + (howManyDaysInMonthOfYear(_year, _month) - _day);

	return days;
}
void textcolor(int color_number) { 
SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), color_number); 
}


