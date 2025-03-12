public interface Observer
{
    void update(EnvironmentState state);

    void update(SystemState state);
}
