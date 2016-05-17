package cn.edu.zju.cst.ideas.domain;

import java.util.List;

public class PageBean {
	
	/**
	 * ��ǰҳ
	 */
	private int currentPage;
	/**
	 * ÿҳ��ʾ������
	 */
	private int pageSize;

	/**
	 * �ܼ�¼��
	 */
	private int recordCount;
	/**
	 * ��ҳ�������б�
	 */
	private List recordList;

	/**
	 * ��ҳ��
	 */
	private int pageCount;
	/**
	 * ҳ���б�Ŀ�ʼ������������
	 */
	private int beginPageIndex;
	/**
	 * ҳ���б�Ľ���������������
	 */
	private int endPageIndex;
	
	/**
	 * ֻ����ǰ4����Ҫ�����ԣ����Զ��ļ��������3��������ֵ
	 * 
	 * @param currentPage ��ǰҳ
	 * @param pageSize ÿҳ��ʾ����
	 * @param recordCount �ܼ�¼��
	 * @param recordList ��ҳ�����б�
	 */
	public PageBean(int currentPage, int pageSize, int recordCount, List recordList) {
		this.currentPage = currentPage;
		this.pageSize = pageSize;
		this.recordCount = recordCount;
		this.recordList = recordList;

		// ������ҳ��
		pageCount = (recordCount + pageSize - 1) / pageSize;

		// ���� beginPageIndex �� endPageIndex
		// >> ��ҳ��������10ҳ����ȫ����ʾ
		if (pageCount <= 10) {
			beginPageIndex = 1;
			endPageIndex = pageCount;
		}
		// >> ��ҳ������10ҳ������ʾ��ǰҳ�����Ĺ�10��ҳ��
		else {
			// ��ǰҳ�����Ĺ�10��ҳ�루ǰ4�� + ��ǰҳ + ��5����
			beginPageIndex = currentPage - 4;
			endPageIndex = currentPage + 5;
			// ��ǰ���ҳ�벻��4��ʱ������ʾǰ10��ҳ��
			if (beginPageIndex < 1) {
				beginPageIndex = 1;
				endPageIndex = 10;
			}
			// �������ҳ�벻��5��ʱ������ʾ��10��ҳ��
			if (endPageIndex > pageCount) {
				endPageIndex = pageCount;
				beginPageIndex = pageCount - 10 + 1;
			}
		}
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getRecordCount() {
		return recordCount;
	}

	public void setRecordCount(int recordCount) {
		this.recordCount = recordCount;
	}

	public List getRecordList() {
		return recordList;
	}

	public void setRecordList(List recordList) {
		this.recordList = recordList;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public int getBeginPageIndex() {
		return beginPageIndex;
	}

	public void setBeginPageIndex(int beginPageIndex) {
		this.beginPageIndex = beginPageIndex;
	}

	public int getEndPageIndex() {
		return endPageIndex;
	}

	public void setEndPageIndex(int endPageIndex) {
		this.endPageIndex = endPageIndex;
	}
	
}
