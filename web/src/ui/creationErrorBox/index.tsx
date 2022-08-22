
type CreationErrorProps = {
    show: boolean,
    message: string;
}

const ErrorBox: React.FC<CreationErrorProps> = (props) => {
    if (!props.show) return null;

    return (
        <div className="error-box">
            {props.message}
        </div>
    )
}

export default ErrorBox;