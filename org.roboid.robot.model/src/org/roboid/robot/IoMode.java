/*
 * Part of the ROBOID project
 * Copyright (C) 2016 Kwang-Hyun Park (akaii@kw.ac.kr) and Kyoung Jin Kim
 * https://github.com/roboidstudio/embedded
 * 
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 * 
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General
 * Public License along with this library; if not, write to the
 * Free Software Foundation, Inc., 59 Temple Place, Suite 330,
 * Boston, MA  02111-1307  USA
*/

package org.roboid.robot;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Io Mode</b></em>',
 * and utility methods for working with them.
 * @author Kwang-Hyun Park
 * <!-- end-user-doc -->
 * @see org.roboid.robot.RobotPackage#getIoMode()
 * @model
 * @generated
 */
public enum IoMode implements Enumerator {
	/**
	 * The '<em><b>NONE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NONE_VALUE
	 * @generated
	 * @ordered
	 */
	NONE(-1, "NONE", "NONE"),

	/**
	 * The '<em><b>ANALOG INPUT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ANALOG_INPUT_VALUE
	 * @generated
	 * @ordered
	 */
	ANALOG_INPUT(0, "ANALOG_INPUT", "ANALOG_INPUT"),

	/**
	 * The '<em><b>DIGITAL INPUT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DIGITAL_INPUT_VALUE
	 * @generated
	 * @ordered
	 */
	DIGITAL_INPUT(1, "DIGITAL_INPUT", "DIGITAL_INPUT"),

	/**
	 * The '<em><b>SERVO OUTPUT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SERVO_OUTPUT_VALUE
	 * @generated
	 * @ordered
	 */
	SERVO_OUTPUT(8, "SERVO_OUTPUT", "SERVO_OUTPUT"),

	/**
	 * The '<em><b>PWM OUTPUT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PWM_OUTPUT_VALUE
	 * @generated
	 * @ordered
	 */
	PWM_OUTPUT(9, "PWM_OUTPUT", "PWM_OUTPUT"),

	/**
	 * The '<em><b>DIGITAL OUTPUT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DIGITAL_OUTPUT_VALUE
	 * @generated
	 * @ordered
	 */
	DIGITAL_OUTPUT(10, "DIGITAL_OUTPUT", "DIGITAL_OUTPUT");

	/**
	 * The '<em><b>NONE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>NONE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #NONE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int NONE_VALUE = -1;

	/**
	 * The '<em><b>ANALOG INPUT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ANALOG INPUT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ANALOG_INPUT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ANALOG_INPUT_VALUE = 0;

	/**
	 * The '<em><b>DIGITAL INPUT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>DIGITAL INPUT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DIGITAL_INPUT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int DIGITAL_INPUT_VALUE = 1;

	/**
	 * The '<em><b>SERVO OUTPUT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SERVO OUTPUT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SERVO_OUTPUT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SERVO_OUTPUT_VALUE = 8;

	/**
	 * The '<em><b>PWM OUTPUT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>PWM OUTPUT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #PWM_OUTPUT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int PWM_OUTPUT_VALUE = 9;

	/**
	 * The '<em><b>DIGITAL OUTPUT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>DIGITAL OUTPUT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DIGITAL_OUTPUT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int DIGITAL_OUTPUT_VALUE = 10;

	/**
	 * An array of all the '<em><b>Io Mode</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final IoMode[] VALUES_ARRAY =
		new IoMode[] {
			NONE,
			ANALOG_INPUT,
			DIGITAL_INPUT,
			SERVO_OUTPUT,
			PWM_OUTPUT,
			DIGITAL_OUTPUT,
		};

	/**
	 * A public read-only list of all the '<em><b>Io Mode</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<IoMode> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Io Mode</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static IoMode get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			IoMode result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Io Mode</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static IoMode getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			IoMode result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Io Mode</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static IoMode get(int value) {
		switch (value) {
			case NONE_VALUE: return NONE;
			case ANALOG_INPUT_VALUE: return ANALOG_INPUT;
			case DIGITAL_INPUT_VALUE: return DIGITAL_INPUT;
			case SERVO_OUTPUT_VALUE: return SERVO_OUTPUT;
			case PWM_OUTPUT_VALUE: return PWM_OUTPUT;
			case DIGITAL_OUTPUT_VALUE: return DIGITAL_OUTPUT;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final int value;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String name;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String literal;

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private IoMode(int value, String name, String literal) {
		this.value = value;
		this.name = name;
		this.literal = literal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getValue() {
	  return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
	  return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLiteral() {
	  return literal;
	}

	/**
	 * Returns the literal value of the enumerator, which is its string representation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		return literal;
	}
	
} //IoMode
