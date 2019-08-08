package org.mquezada.exercises;

import org.mquezada.util.LinkedListNode;
       
public class LinkedLists {
 public void deleteDups(LinkedListNode head){
  if(head == null) return;
  
  LinkedListNode current = head;
  while(current != null){
    //Remove all future nodes that have the same value
    LinkedListNode runner = current;
    while(runner.next != null){
      if(runner.next.data == current.data)
        runner.next = runner.next.next;
      else
        runner = runner.next;
    }
  }
 }
}
