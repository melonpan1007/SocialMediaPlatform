/*
package com.example.social_media_platform.datastructures;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

class TrieNode {
    Map<Character, TrieNode> children = new HashMap<>();
    boolean isEndOfWord = false;
}
@Component
public class UsernameTrie {
    private TrieNode root;

    public UsernameTrie() {
        root = new TrieNode();
    }

    public void insert(String username) {
        TrieNode node = root;
        for (char ch : username.toCharArray()) {
            node = node.children.computeIfAbsent(ch, c -> new TrieNode());
        }
        node.isEndOfWord = true;
    }

    public boolean search(String username) {
        TrieNode node = root;
        for (char ch : username.toCharArray()) {
            node = node.children.get(ch);
            if (node == null) {
                return false;
            }
        }
        return node.isEndOfWord;
    }

    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for (char ch : prefix.toCharArray()) {
            node = node.children.get(ch);
            if (node == null) {
                return false;
            }
        }
        return true;
    }
}
*/
