package com.zhijiansihang.sys.dialect;

import com.zhijiansihang.sys.dialect.Schema.Tables;

import javax.persistence.*;
import java.io.Serializable;

@MappedSuperclass
public abstract class AbstractSyslog implements Serializable {

	private static final long serialVersionUID = 1L;
	private static final String SEQUENCE = Tables.SYSLOG + Schema.SEQ_SUFFIX;

//	@SequenceGenerator(name = SEQUENCE, sequenceName = SEQUENCE)
//	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQUENCE)
//	@Id
	@GeneratedValue
	@Id
	@Column(name = "ID",length = 40,unique = true,nullable = false)
	protected Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}