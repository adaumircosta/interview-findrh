package br.com.sankhya.projeto.system;

import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class SupportSystem {
    private static final Logger logger = Logger.getLogger(SupportSystem.class);

    public static SupportRequestInfo processSupportRequest(String issue) {
        return resolveIssue(new SupportRequestInfo(issue), SupportLevel.LEVEL_1);
    }

    private static SupportRequestInfo resolveIssue(SupportRequestInfo request, SupportLevel level) {
        if(level == null){
            request.addAnalysis("Resume Analysis not resolved :( ...");
            return request;
        }

        logger.info("Attempting to resolve issue at " + level + " support level.");

        boolean resolved = false;

        switch (level) {
            case LEVEL_1:
                resolved = resolveIssueAtLevel1(request);
                break;
            case LEVEL_2:
                resolved = resolveIssueAtLevel2(request);
                break;
            case LEVEL_3:
                resolved = resolveIssueAtLevel3(request);
                break;
            default:
                logger.error("Unknown support level.");
                return null;
        }

        if (!resolved) {
            logger.warn("Issue not resolved at " + level + " support. Escalating...");
            return resolveIssue(request, getNextSupportLevel(level));
        } else {
            logger.info("Issue resolved at " + level + " support level.");
            return request;
        }
    }

    private static SupportLevel getNextSupportLevel(SupportLevel currentLevel) {
        switch (currentLevel) {
            case LEVEL_1:
                return SupportLevel.LEVEL_2;
            case LEVEL_2:
                return SupportLevel.LEVEL_3;
            case LEVEL_3:
                return null;
            default:
                return null;
        }
    }

    private static boolean resolveIssueAtLevel1(SupportRequestInfo request) {
        logger.info("Level 1 support handling request issue");

        // Retrieve previous analyses
        List<String> previousAnalyses = request.getAnalyses();

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

    private static boolean resolveIssueAtLevel2(SupportRequestInfo request) {
        logger.info("Level 2 support handling request issue");
        // Retrieve previous analyses
        List<String> previousAnalyses = request.getAnalyses();

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

    private static boolean resolveIssueAtLevel3(SupportRequestInfo request) {
        logger.info("Level 3 support handling request issue");
        // Retrieve previous analyses
        List<String> previousAnalyses = request.getAnalyses();

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

    private static enum SupportLevel {
        LEVEL_1,
        LEVEL_2,
        LEVEL_3;
    }

    public static class SupportRequestInfo {
        private final String issue;
        private final List<String> analyses;

        public SupportRequestInfo(String issue) {
            this.issue = issue;
            this.analyses = new ArrayList<>();
        }

        public String getIssue() {
            return issue;
        }

        public void addAnalysis(String analysis) {
            analyses.add(analysis);
        }

        public List<String> getAnalyses() {
            return new ArrayList<>(analyses);
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