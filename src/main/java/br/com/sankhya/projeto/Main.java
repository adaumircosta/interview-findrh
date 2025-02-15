package br.com.sankhya.projeto;

import br.com.sankhya.projeto.system.SupportSystem;
import org.apache.log4j.Logger;

public class Main {
    private static final Logger logger = Logger.getLogger(SupportSystem.class);

    public static void main(String[] args) {
        SupportSystem.SupportRequestInfo request = SupportSystem.processSupportRequest(
                "The application crashes inconsistently when users attempt to submit their forms. " +
                        "The crashes occur after the form has been filled out and the 'Submit' button is clicked. " +
                        "Users reported that they occasionally receive a generic error message stating 'An unexpected error has occurred.'"
        );
        logger.info(request.toString());
    }
}
