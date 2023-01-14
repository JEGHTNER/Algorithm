#include<iostream>
#include<map>

void printDictionary(std::map<std::string,int> dic)
{
	for (auto p : dic)
    std::cout << "key = "<<p.first << ' ' <<"value = "<<p.second << '\n';
}
void printDictionary(std::map<int,int> dic)
{
	for (auto p : dic)
    std::cout << "key = "<<p.first << ' ' <<"value = "<<p.second << '\n';
}
void printDictionary(std::map<int,std::string> dic)
{
	for (auto p : dic)
    std::cout << "key = "<<p.first << ' ' <<"value = "<<p.second << '\n';
}

void printDictionary(std::map<char,int> dic)
{
	for (auto p : dic)
    std::cout << "key = "<<p.first << ' ' <<"value = "<<p.second << '\n';
}
void printDictionary(std::map<int,char> dic)
{
	for (auto p : dic)
    std::cout << "key = "<<p.first << ' ' <<"value = "<<p.second << '\n';
}