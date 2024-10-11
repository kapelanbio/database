/**
 *
 * $Id$
 */
package org.eclipse.emf.examples.extlibrary.validation;

import java.util.Date;

/**
 * A sample validator interface for {@link org.eclipse.emf.examples.extlibrary.Item}.
 * This doesn't really do anything, and it's not a real EMF artifact.
 * It was generated by the org.eclipse.emf.examples.generator.validator plug-in to illustrate how EMF's code generator can be extended.
 * This can be disabled with -vmargs -Dorg.eclipse.emf.examples.generator.validator=false.
 */
public interface ItemValidator {
	boolean validate();

	boolean validateId(int value);
	boolean validatePublicationDate(Date value);
}
