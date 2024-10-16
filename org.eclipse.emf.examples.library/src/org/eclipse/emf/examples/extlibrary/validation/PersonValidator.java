/**
 *
 * $Id$
 */
package org.eclipse.emf.examples.extlibrary.validation;


/**
 * A sample validator interface for {@link org.eclipse.emf.examples.extlibrary.Person}.
 * This doesn't really do anything, and it's not a real EMF artifact.
 * It was generated by the org.eclipse.emf.examples.generator.validator plug-in to illustrate how EMF's code generator can be extended.
 * This can be disabled with -vmargs -Dorg.eclipse.emf.examples.generator.validator=false.
 */
public interface PersonValidator {
	boolean validate();

	boolean validateId(int value);
	boolean validateFirstName(String value);
	boolean validateLastName(String value);
}
