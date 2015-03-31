public class HeapElt {

	@SuppressWarnings("rawtypes")
	protected Comparable record;

	protected int handle = 0;

	@SuppressWarnings("rawtypes")
	public void setRecord(Comparable inRec) {
		record = inRec;
	}

	@SuppressWarnings("rawtypes")
	public Comparable getRecord() {
		return record;
	}

	public void setHandle(int inHandle) {
		handle = inHandle;
	}

	public int getHandle() {
		return handle;
	}
}
