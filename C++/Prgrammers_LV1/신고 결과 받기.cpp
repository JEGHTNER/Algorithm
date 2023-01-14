#include <string>
#include <vector>
#include <set>
#include <map>
#include <sstream>
#include "printVector.cpp"
using namespace std;


vector<string> split(string input, char delimiter) {
    vector<string> answer;
    stringstream ss(input);
    string temp;
 
    while (getline(ss, temp, delimiter)) {
        answer.push_back(temp);
    }
    return answer;
}


vector<int> solution(vector<string> id_list, vector<string> report, int k) {
    vector<int> answer;

	set<string> s_report(report.begin(), report.end());
	map<string, int> dic;
	for (auto id : id_list)
		answer.push_back(0);
	for (auto iter : s_report)
		dic[split(iter, ' ')[1]] += 1;
	for (auto iter : s_report)
	{
		if (dic[split(iter, ' ')[1]] >= k)
		{
			//int index = distance(id_list.begin(),find(id_list.begin(), id_list.end(), split(iter, ' ')[0]));
			int index = find(id_list.begin(), id_list.end(), split(iter, ' ')[0]) - id_list.begin();
			answer[index]++;
		}
	}
    return answer;
}

int main()
{
	vector<string> id_list ={"muzi", "frodo", "apeach", "neo"};
	vector<string> report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
	int k = 2;

	printVector(solution(id_list, report, k));
}