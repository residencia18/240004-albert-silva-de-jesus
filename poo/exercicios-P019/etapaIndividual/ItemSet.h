#ifndef ITEMSET_H
#define ITEMSET_H
#include <iostream>
#include <string>
#include <vector>

using namespace std;

#pragma once

class ItemSet
{
public:
    vector<string> items;
    ItemSet();

    ~ItemSet();

    vector<string> getItems(){
        return items;
    }

    void setItems(vector<string> items){
        this->items = items;
    }

private:

};

#endif