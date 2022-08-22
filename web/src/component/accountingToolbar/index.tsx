import { Link } from "react-router-dom";
import './style.css';

const AccountingToolbar: React.FC = () => {
  return (
    <div className="accountToolbarContainer">
      <div className="accountToolbarItems">
        <Link className="accountToolbarLink" to={"/"}>
          <div className="accountToolbarItem">Transactions</div>
        </Link>
        <Link className="accountToolbarLink" to={"/account/create"}>
          <div className="accountToolbarItem">New Account</div>
        </Link>
        <Link className="accountToolbarLink" to={"/transaction/create"}>
          <div className="accountToolbarItem">New Transaction</div>
        </Link>
      </div>
    </div>
  );
};

export default AccountingToolbar;
