package de.hpi.bpmn;


public abstract class Node extends DiagramObject {
	
	protected String label;
	protected Container parent;
	protected Container process;
	
	public String toString() {
		return (label != null ? label : resourceId);
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		if (label != null)
			label = label.replace("\n", "_").replace(" ", "_");
		this.label = label;
	}

	public Container getParent() {
		return parent;
	}

	public void setParent(Container parent) {
		if (this.parent != parent) {
			if (this.parent != null && this.parent != this.process)
				this.parent.getChildNodes().remove(this);
			if (parent != null && parent != this.process)
				parent.getChildNodes().add(this);
		}
		this.parent = parent;
	}

	public Container getProcess() {
		return process;
	}

	public void setProcess(Container process) {
		if (this.process != process) {
			if (this.process != null && this.process != this.parent)
				this.process.getChildNodes().remove(this);
			if (process != null && process != this.parent)
				process.getChildNodes().add(this);
		}
		this.process = process;
	}

}