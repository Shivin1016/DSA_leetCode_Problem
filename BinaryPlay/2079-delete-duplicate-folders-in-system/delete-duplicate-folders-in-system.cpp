class Solution {
public:
    //Construct trie
    struct Node{
        string name; // name of the folder
        string subFolder; // subfolder structure
        unordered_map<string , Node*> children; 
    };

    Node* getNewNode(string name){
        Node* temp = new Node();
        temp->name = name;
        temp->subFolder = ""; //starting empty subfolder

        return temp;
    }
    void insert(Node* root , vector<string> path){

        for(auto& folder : path){

            if(!root->children.count(folder)){
                root->children[folder] = getNewNode(folder);
            }

            root = root->children[folder];
        }
    }

    string populateNode(Node* root , unordered_map<string , int>& subFolderMap){
        vector<pair<string , string>> subPaths;
        for(auto& [childName , child] : root->children){
            string subFolderRes = populateNode(child , subFolderMap);
            subPaths.push_back({childName , subFolderRes});
        }
        sort(begin(subPaths) , end(subPaths));

        string completePath = "";
        for(auto& [childName , childStruct] : subPaths){
            completePath += "(" + childName + childStruct + ")";
        }

        root->subFolder = completePath;
        if(!completePath.empty()){
            subFolderMap[completePath]++;
        }

        return completePath;
    }

    void removeDuplicates(Node* root , unordered_map<string , int>& subFolderMap){
        for(auto it = root->children.begin() ; it != root->children.end() ;){
            string childName = it->first;
            Node* child = it->second;
            if(!child->subFolder.empty() && subFolderMap[child->subFolder] > 1){
                it = root->children.erase(it);
            }else{
                removeDuplicates(child , subFolderMap);
                it++;
            }
        }
    }

    void constructResult(Node* root , vector<vector<string>>& result , vector<string>& path){
        for(auto& [childName , child] : root->children){
            path.push_back(childName);
            result.push_back(path);
            constructResult(child , result , path);
            path.pop_back();
        }
    }
    vector<vector<string>> deleteDuplicateFolder(vector<vector<string>>& paths) {
        //make root node
        Node* root = getNewNode("/");

        //step 1-> construct trie of paths
        for(auto& path : paths){
            insert(root , path);
        }

        unordered_map<string , int> subFolderMap ; // store count of each folder

        //step 2-> populate subFolder
        populateNode(root , subFolderMap);

        //step 3--. remove
        removeDuplicates(root , subFolderMap);

        //step 04-> final result
        vector<vector<string>> result;
        vector<string> path;
        constructResult(root , result , path);

        return result;
    }
};