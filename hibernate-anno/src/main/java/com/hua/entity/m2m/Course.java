/**
* Course.java
* 
* @author qye.zheng
* 	version 1.0
 */
package com.hua.entity.m2m;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.GenericGenerator;

import com.hua.entity.BaseEntity;


/**
 * 描述: 
 * @author qye.zheng
 * Course
 */
@Entity
@Table(name = "course")
public final class Course extends BaseEntity {
	
	@GenericGenerator(name = "idGenerator", strategy = "native")
	@GeneratedValue(generator = "idGenerator")
	@Column(name = "id", insertable = true, 
			updatable = false, length = 64, 
			nullable = false, unique = true)
	@Id
	/* 对象唯一id */
	private String id;
	
	@Column(name = "name", insertable = true, 
			updatable = true, length = 64, 
			nullable = true, unique = false)
	/* 课程名称 */
	private String name;
	
	@Column(name = "credit", insertable = true, 
			updatable = true, precision = 2,
			nullable = true, unique = false)
	/* 该课程的学分 */
	private Double credit;
	
	@Column(name = "description", insertable = true, 
			updatable = true, length = 128, 
			nullable = true, unique = false)
	/* 课程描述 */
	private String description;
	
	@Column(name = "courseId", insertable = true, 
			updatable = true, nullable = true, unique = false)
	@ManyToMany
	@JoinTable(name = "student_course", 
	joinColumns = {@JoinColumn(name = "courseId")},
	inverseJoinColumns = {@JoinColumn(name = "studentId")},
	uniqueConstraints = {@UniqueConstraint(
	columnNames = {"studentId", "courseId"})})
	/* 选择该课程的所有学生 */
	private Set<Student> students = new HashSet<Student>();
	
	/** 无参构造方法 */
	public Course() {
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the credit
	 */
	public Double getCredit() {
		return credit;
	}

	/**
	 * @param credit the credit to set
	 */
	public void setCredit(Double credit) {
		this.credit = credit;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the students
	 */
	public Set<Student> getStudents()
	{
		return students;
	}

	/**
	 * @param students the students to set
	 */
	public void setStudents(Set<Student> students)
	{
		this.students = students;
	}

	/**
	 * @description 
	 * @return
	 * @author qye.zheng
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	/**
	 * @description 
	 * @param obj
	 * @return
	 * @author qye.zheng
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Course other = (Course) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	/**
	 * @return the id
	 */
	public final String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public final void setId(String id) {
		this.id = id;
	}
	
	
}
