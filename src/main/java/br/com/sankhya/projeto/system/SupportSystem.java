package br.com.sankhya.projeto.system;

import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class SupportSystem {
    private static final Logger logger = Logger.getLogger(SupportSystem.class);
    private static final List<SupportHandler> handlers = new ArrayList<>();

    static {
        handlers.add(new Level1SupportHandler());
        handlers.add(new Level2SupportHandler());
        handlers.add(new Level3SupportHandler());
        handlers.add(new Level4SupportHandler());
    }

    public static SupportRequestInfo processSupportRequest(String issue) {

        SupportRequestInfo request = new SupportRequestInfo(issue);
        for (SupportHandler handler : handlers) {
            if (handler.handle(request)) {
                logger.info("Issue resolved by " + handler.getClass().getSimpleName());
                return request;
            }
        }
        logger.warn("Issue not resolved by any support level.");
        return request;
    }

    public interface SupportHandler {
        boolean handle(SupportRequestInfo request);
    }

    public static class Level1SupportHandler implements SupportHandler {

        @Override
        public boolean handle(SupportRequestInfo request) {

            logger.info("Level 1 support handling request issue");

            // Simulate problem-solving based on previous analyses
            boolean resolved = false;

            if (resolved) {
                logger.info("Issue resolved at Level 1 support.");
                return true; // Issue resolved
            } else {
                logger.warn("Issue not resolved at Level 1 support.");
                request.addAnalysis("Resume Analysis Level 1 Support...");
                return false; // Issue not resolved
            }
        }
    }

    public static class Level2SupportHandler implements SupportHandler {

        @Override
        public boolean handle(SupportRequestInfo request) {

            logger.info("Level 2 support handling request issue");

            // Simulate problem-solving based on previous analyses
            boolean resolved = false;

            if (resolved) {
                logger.info("Issue resolved at Level 2 support.");
                return true; // Issue resolved
            } else {
                logger.warn("Issue not resolved at Level 2 support.");
                request.addAnalysis("Resume Analysis Level 2 Support...");
                return false; // Issue not resolved
            }
        }
    }

    public static class Level3SupportHandler implements SupportHandler {
        @Override
        public boolean handle(SupportRequestInfo request) {

            logger.info("Level 3 support handling request issue");

            // Simulate problem-solving based on previous analyses
            boolean resolved = false;

            if (resolved) {
                logger.info("Issue resolved at Level 3 support.");
                return true; // Issue resolved
            } else {
                logger.warn("Issue not resolved at Level 3 support.");
                request.addAnalysis("Resume Analysis Level 3 Support...");
                return false; // Issue not resolved
            }
        }
    }

    public static class Level4SupportHandler implements SupportHandler {
        @Override
        public boolean handle(SupportRequestInfo request) {

            logger.info("Level 4 support handling request issue");

            // Simulate problem-solving based on previous analyses
            boolean resolved = true;

            if (resolved) {
                logger.info("Issue resolved at Level 4 support.");
                return true; // Issue resolved
            } else {
                logger.warn("Issue not resolved at Level 4 support.");
                request.addAnalysis("Resume Analysis Level 3 Support...");
                return false; // Issue not resolved
            }
        }
    }

    public static class SupportRequestInfo {
        private final String issue;
        private final List<String> analyses;

        public SupportRequestInfo(String issue) {
            this.issue = issue;
            this.analyses = new ArrayList<>();
        }

        public void addAnalysis(String analysis) {
            analyses.add(analysis);
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Support Request Information:\n");
            sb.append("Issue: ").append(issue).append("\n");
            sb.append("Analyses:\n");

            if (analyses.isEmpty()) {
                sb.append("  No analyses available.\n");
            } else {
                for (String analysis : analyses) {
                    sb.append("  - ").append(analysis).append("\n");
                }
            }

            return sb.toString();
        }
    }
}