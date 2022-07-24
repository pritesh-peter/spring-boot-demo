package com.dailycode.Springboot.demo.error;

public class DepartmentNotFoundException extends Exception {

    public DepartmentNotFoundException()
    {
        super();
    }

    public DepartmentNotFoundException(final String argMessage, final Throwable argCause)
    {
        super(argMessage, argCause);
    }

    public DepartmentNotFoundException(final String argMessage)
    {
        super(argMessage);
    }

    public DepartmentNotFoundException(final Throwable argCause)
    {
        super(argCause);
    }

	}

