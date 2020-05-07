package com.xmh.utils;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class PageHelper<T> {

	//ÿҳ��ʾ����
	private int size=5;
	//��ҳ��
	private int page_total;
	//�ܼ�¼��
	private int counts;
	//��ǰҳ
	private int now_page;
	//�Ƿ���һҳ
	private boolean prev;
	//�Ƿ���һҳ
	private boolean next;
	
	//�洢��ҳ��Ϣ
	private List<T> list;
	
	public void setList(List<T> list) {
		this.list = list;
	}
	public List<T> getList() {
		return list;
	}
	
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public int getPage_total() {
		if(counts%size==0) {
			this.page_total =counts/size; 
		}else {
			this.page_total = counts/size+1;
		}
		return page_total;
	}
	public void setPage_total(int page_total) {
		this.page_total = page_total;
	}
	public int getCounts() {
		return counts;
	}
	public void setCounts(int counts) {
		this.counts = counts;
	}
	public int getNow_page() {
		return now_page;
	}
	public void setNow_page(int now_page) {
		this.now_page = now_page;
	}
	public boolean isPrev() {
		return prev;
	}
	public void setPrev(boolean prev) {
		this.prev = prev;
	}
	public boolean isNext() {
		return next;
	}
	public void setNext(boolean next) {
		this.next = next;
	}
	

	
	
}
